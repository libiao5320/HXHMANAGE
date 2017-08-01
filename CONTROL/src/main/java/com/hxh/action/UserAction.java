package com.hxh.action;


import com.hxh.model.*;
import com.hxh.model.TbUserAddress;
import com.hxh.model.TbUserExt;
import com.hxh.services.TbUser.TbUserService;
import com.hxh.services.TbUserAccount.TbUserAccountService;
import com.hxh.services.TbUserAddress.TbUserAddressService;
import com.hxh.services.TbUserExt.TbUserExtService;
import com.hxh.util.MapUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import org.apache.tools.ant.util.DateUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/2.
 */
public class UserAction extends BaseAction {


    private HttpServletRequest request = null;
    private HttpServletResponse response = null;

    private TbUserService tbUserService = null;
    private TbUserExtService tbUserExtService = null;
    private TbUserAccountService tbUserAccountService = null;
    private TbUserAddressService tbUserAddressService = null;

    public void setTbUserService(TbUserService tbUserService) {
        this.tbUserService = tbUserService;
    }

    public void setTbUserExtService(TbUserExtService tbUserExtService) {
        this.tbUserExtService = tbUserExtService;
    }

    public void setTbUserAccountService(TbUserAccountService tbUserAccountService) {
        this.tbUserAccountService = tbUserAccountService;
    }

    public void setTbUserAddressService(TbUserAddressService tbUserAddressService) {
        this.tbUserAddressService = tbUserAddressService;
    }

    /**
     * 查询用户信息列表
     * @return
     */
    public String queryUsers() {

        request = getRequest();
        response = getResponse();

        String aoData = request.getParameter("aoData");

        JSONArray jsonarray = JSONArray.fromObject(aoData);
        int iDisplayStart = 0; // 起始索引
        int iDisplayLength = 10; // 每页显示的行数
        String sEcho = null;
        for (int i = 0; i < jsonarray.size(); i++) {
            if (jsonarray.get(i)==null || jsonarray.get(i) instanceof JSONNull) {
                continue;
            }
            JSONObject obj = (JSONObject) jsonarray.get(i);
            if (obj.get("name").equals("sEcho"))
                sEcho = obj.get("value").toString();
            if (obj.get("name").equals("iDisplayStart"))
                iDisplayStart = obj.getInt("value");
            if (obj.get("name").equals("iDisplayLength"))
                iDisplayLength = obj.getInt("value");
        }

        try {
            Map<String,Object> paramMap = MapUtil.getParameterMap(request);
            List<TbCommunity> list = tbUserService.listUser(paramMap);
            JSONObject result = new JSONObject();
            result.put("sEcho", sEcho);
            result.put("iTotalRecords", list.size());//实际的行数
            result.put("iTotalDisplayRecords", list.size());//显示的行数
            result.put("aaData",list);
            print(response, result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获得用户明细信息
     * @return
     */
    public String getUserDetail () {
        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();

        try {
            String userId = request.getParameter("userId");
            TbUser tbUser = tbUserService.queryById(userId);
            TbUserExt tbUserExt = tbUserExtService.queryById(tbUser.getUserId().toString());
            result.put("userInfo",tbUser);
            result.put("userExt",tbUserExt);

            print(response, result.toString());
        } catch (Exception e) {
            // 查询失败
            try {
                result.put("resultCode",3);
                print(response, result.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

        return null;
    }


    /**
     * 添加用户信息
     * @return
     */
    public String addUser() {
        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();
        try {
            String userName = request.getParameter("userName");
            String userSex = request.getParameter("userSex");
            String userPhone = request.getParameter("userPhone");
            String userState = request.getParameter("userState");
            TbUser tbUser = new TbUser();
            tbUser.setUserName(userName);
            tbUser.setUserSex(Integer.parseInt(userSex));
            tbUser.setUserPhone(userPhone);
            tbUser.setUserState(Integer.parseInt(userState));
            tbUser.setUserRegdate(DateUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
            String id = tbUserService.save(tbUser);

            if (id != null) {
                // 添加成功
                result.put("resultCode",1);
            } else {
                // 添加失败
                result.put("resultCode",2);
            }

            print(response, result.toString());
        } catch (Exception e) {
            // 添加失败
            try {
                result.put("resultCode",3);
                print(response, result.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新用户信息
     * @return
     */
    public String updateUser() {
        request = getRequest();
        response = getResponse();
        JSONObject result = new JSONObject();

        try {
            String userId = request.getParameter("userId");
            String userName = request.getParameter("userName");
            String userSex = request.getParameter("userSex");
            String userPhone = request.getParameter("userPhone");
            String userState = request.getParameter("userState");
            TbUser tbUser = new TbUser();
            tbUser.setUserId(Integer.parseInt(userId));
            tbUser.setUserName(userName);
            tbUser.setUserSex(Integer.parseInt(userSex));
            tbUser.setUserPhone(userPhone);
            tbUser.setUserState(Integer.parseInt(userState));

            String userMail = request.getParameter("userMail");
            String userBirday = request.getParameter("userBirday");
            TbUserExt tbUserExt = new TbUserExt();
            tbUserExt.setUserId(Integer.parseInt(userId));
            tbUserExt.setUserMail(userMail);
            tbUserExt.setUserBirday(userBirday);

            boolean isUpdated = tbUserService.update(tbUser,tbUserExt);

            if (isUpdated) {
                // 更新成功
                result.put("resultCode",1);
            } else {
                // 更新失败
                result.put("resultCode",2);
            }

            print(response, result.toString());
        } catch (Exception e) {
            // 更新失败
            try {
                result.put("resultCode",3);
                print(response, result.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除用户信息
     * @return
     */
//    public String deleteUser() {
//        request = getRequest();
//        response = getResponse();
//        JSONObject result = new JSONObject();
//
//        try {
//            String userId = request.getParameter("userId");
//            String id = tbUserService.deleteById(userId);
//
//            if (id != null) {
//                // 删除成功
//                result.put("resultCode",1);
//            } else {
//                // 删除失败
//                result.put("resultCode",2);
//            }
//
//            print(response, result.toString());
//        } catch (Exception e) {
//            // 删除失败
//            try {
//                result.put("resultCode",3);
//                print(response, result.toString());
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//            e.printStackTrace();
//        }
//        return null;
//    }


    /**
     * 添加电话下单用户信息
     * @return
     */
    public String addPhoneUser()
    {
        request = getRequest();
        response = getResponse();
        JSONObject result = new JSONObject();


        String phone = request.getParameter("phone");
        String commId = request.getParameter("commId");


        String addressDesc = request.getParameter("addressDesc");



        TbUser user = new TbUser();
        TbUserAddress userAddress = new TbUserAddress();
        TbUserExt  tbUserExt = new TbUserExt();


        user.setUserName("");
        user.setUserPhone("");
        user.setUserRegdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        user.setUserSex(1);
        user.setUserState(1);



        userAddress.setUserId(user.getUserId());
        userAddress.setCommId(Integer.parseInt(commId));

        userAddress.setAddressDesc(addressDesc);



        tbUserExt.setUserId(user.getUserId());








        return null;
    }


}

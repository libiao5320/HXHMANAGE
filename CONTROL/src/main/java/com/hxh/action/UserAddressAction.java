package com.hxh.action;


import com.hxh.model.TbUserAddress;
import com.hxh.services.TbUserAddress.TbUserAddressService;
import net.sf.json.JSONObject;
import org.apache.tools.ant.util.DateUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/2.
 */
public class UserAddressAction extends BaseAction {


    private HttpServletRequest request = null;
    private HttpServletResponse response = null;

    private TbUserAddressService tbUserAddressService = null;

    public void setTbUserAddressService(TbUserAddressService tbUserAddressService) {
        this.tbUserAddressService = tbUserAddressService;
    }

    /**
     * 获得用户地址信息
     * @return
     */
    public String getUserAddress() {
        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();

        try {
            String userId = request.getParameter("userId");
            String addressType = request.getParameter("addressType");
            TbUserAddress tbUserAddress = new TbUserAddress();
            tbUserAddress.setUserId(Integer.parseInt(userId));
            tbUserAddress.setAddressType(Integer.parseInt(addressType));
            List<Map<String,Object>> tbUserAddressList = tbUserAddressService.listUserAddr(tbUserAddress);
            result.put("userAddressList",tbUserAddressList);

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
     * 添加用户地址信息
     * @return
     */
    public String addUserAddress() {
        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();
        try {
            String userId = request.getParameter("userId");
            String commId = request.getParameter("commId");
            String commDetailId = request.getParameter("commDetailId");
            String addressType = request.getParameter("addressType");
            String addressDesc = request.getParameter("addressDesc");
            TbUserAddress tbUserAddress = new TbUserAddress();
            tbUserAddress.setUserId(Integer.parseInt(userId));
            tbUserAddress.setCommId(Integer.parseInt(commId));
            tbUserAddress.setCommDetailId(Integer.parseInt(commDetailId));
            tbUserAddress.setAddressType(Integer.parseInt(addressType));
            tbUserAddress.setAddressDesc(addressDesc);
            tbUserAddress.setAddressDate(DateUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));

            String id = tbUserAddressService.save(tbUserAddress);

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
     * 更新用户地址信息
     * @return
     */
    public String updateUserAddress() {
        request = getRequest();
        response = getResponse();
        JSONObject result = new JSONObject();

        try {
            String addressId = request.getParameter("addressId");
            String commId = request.getParameter("commId");
            String commDetailId = request.getParameter("commDetailId");
            String addressType = request.getParameter("addressType");
            String addressDesc = request.getParameter("addressDesc");
            String addressStatus = request.getParameter("addressStatus");
            TbUserAddress tbUserAddress = new TbUserAddress();
            tbUserAddress.setAddressId(Integer.parseInt(addressId));
            tbUserAddress.setCommId(Integer.parseInt(commId));
            tbUserAddress.setCommDetailId(Integer.parseInt(commDetailId));
            tbUserAddress.setAddressType(Integer.parseInt(addressType));
            tbUserAddress.setAddressDesc(addressDesc);
            tbUserAddress.setAddressStatus(Integer.parseInt(addressStatus));

            boolean isUpdated = tbUserAddressService.update(tbUserAddress);

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
     * 删除用户地址信息
     * @return
     */
    public String deleteUserAddress() {
        request = getRequest();
        response = getResponse();
        JSONObject result = new JSONObject();

        try {
            String addressId = request.getParameter("addressId");
            String userId = request.getParameter("userId");
            String addressType = request.getParameter("addressType");
            String addressStatus = request.getParameter("addressStatus");

            TbUserAddress tbUserAddress = new TbUserAddress();
            tbUserAddress.setAddressId(Integer.parseInt(addressId));
            tbUserAddress.setUserId(Integer.parseInt(userId));
            tbUserAddress.setAddressType(Integer.parseInt(addressType));
            tbUserAddress.setAddressStatus(Integer.parseInt(addressStatus));
            String id = tbUserAddressService.deleteById(tbUserAddress);

            if (id != null) {
                // 删除成功
                result.put("resultCode",1);
            } else {
                // 删除失败
                result.put("resultCode",2);
            }

            print(response, result.toString());
        } catch (Exception e) {
            // 删除失败
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


}

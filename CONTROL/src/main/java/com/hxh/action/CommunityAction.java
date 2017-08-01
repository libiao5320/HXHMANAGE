package com.hxh.action;


import com.hxh.model.TbCommunity;
import com.hxh.model.TbDisCommRel;
import com.hxh.services.TbCommunity.TbCommunityService;
import com.hxh.services.TbDisCommRel.TbDisCommRelService;
import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/2.
 */
public class CommunityAction extends BaseAction {


    private HttpServletRequest request = null;
    private HttpServletResponse response = null;


    private TbCommunityService tbCommunityService = null;
    private TbDisCommRelService tbDisCommRelService=null;

    public TbDisCommRelService getTbDisCommRelService() {
        return tbDisCommRelService;
    }

    public void setTbDisCommRelService(TbDisCommRelService tbDisCommRelService) {
        this.tbDisCommRelService = tbDisCommRelService;
    }

    public void setTbCommunityService(TbCommunityService tbCommunityService) {
        this.tbCommunityService = tbCommunityService;
    }

    /**
     * 查询小区列表
     * @return
     */
    public String queryCommunities() {

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
            String province = request.getParameter("province");
            String city = request.getParameter("city");
            String district = request.getParameter("district");
            String commName = request.getParameter("commName");

            Map<String, String> paramMap = new HashMap<String,String>();
            paramMap.put("province",province);
            paramMap.put("city",city);
            paramMap.put("district",district);
            paramMap.put("commName",commName);
            List<TbCommunity> list = tbCommunityService.queryFullComm(paramMap);
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

    public String getCommunityForDiser(){
        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();
        try {
            List<TbCommunity> list = tbCommunityService.listAll();
            List<TbDisCommRel> commList = tbDisCommRelService.getByDisId(request.getParameter("disId"));
            List<TbCommunity> listNead = new ArrayList<TbCommunity>();
            for(int i=0;i<commList.size();i++){
                for(int j=0;j<list.size();j++){
                   if(commList.get(i).getCommId().toString().equals(list.get(j).getCommId().toString())){
                       list.remove(j);
                   }
                }
            }
            result.put("list",list);
            print(response, result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getCommunity(){

        request = getRequest();
        response = getResponse();

        try {

            String commId = request.getParameter("commId");

            JSONObject result = new JSONObject();
            Map<String,String> resultMap = tbCommunityService.getCommunityById(commId);

            if (resultMap!= null) {
                result.put("resultCode",1);
                result.putAll(resultMap);
            } else {
                result.put("resultCode",2);
            }

            print(response, result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * 添加小区
     * @return
     */
    public String addCommunity() {
        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();
        try {
            String regionalId = request.getParameter("regionalId");
            String commName = request.getParameter("commName");
            String commDesc = request.getParameter("commDesc");
            String commLongLatitude = request.getParameter("commLongLatitude");
            String disIds = request.getParameter("disId");
            String longLatitude[] = commLongLatitude.trim().split(",");
            String commLongitud = longLatitude[0];
            String commLatitude = longLatitude[1];

            TbCommunity tbCommunity = new TbCommunity();
            tbCommunity.setRegionalId(Integer.parseInt(regionalId));
            tbCommunity.setCommName(commName);
            tbCommunity.setCommDesc(commDesc);
            tbCommunity.setCommLongitud(Double.valueOf(commLongitud));
            tbCommunity.setCommLatitude(Double.valueOf(commLatitude));
            String id = tbCommunityService.save(tbCommunity,disIds);

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
     * 更新小区
     * @return
     */
    public String updateCommunity() {
        request = getRequest();
        response = getResponse();
        JSONObject result = new JSONObject();

        try {
            String commId = request.getParameter("commId");
            String regionalId = request.getParameter("regionalId");
            String commName = request.getParameter("commName");
            String commDesc = request.getParameter("commDesc");
            String commLongLatitude = request.getParameter("commLongLatitude");
            String longLatitude[] = commLongLatitude.trim().split(",");
            String commLongitud = longLatitude[0];
            String commLatitude = longLatitude[1];

            TbCommunity tbCommunity = new TbCommunity();
            tbCommunity.setCommId(Integer.parseInt(commId));
            tbCommunity.setRegionalId(Integer.parseInt(regionalId));
            tbCommunity.setCommName(commName);
            tbCommunity.setCommDesc(commDesc);
            tbCommunity.setCommLongitud(Double.valueOf(commLongitud));
            tbCommunity.setCommLatitude(Double.valueOf(commLatitude));
            String disIds = request.getParameter("disId");
            boolean isUpdated = tbCommunityService.update(tbCommunity,disIds);

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
     * 删除小区，级联删除小区明细
     * @return
     */
    public String deleteCommunity() {
        request = getRequest();
        response = getResponse();
        JSONObject result = new JSONObject();

        try {
            String commId = request.getParameter("commId");
            String id = tbCommunityService.deleteById(commId);

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

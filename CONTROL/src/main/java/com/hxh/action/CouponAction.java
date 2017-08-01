package com.hxh.action;


import com.hxh.model.TbCommunity;
import com.hxh.model.TbDisCommRel;
import com.hxh.services.TbCommunity.TbCommunityService;
import com.hxh.services.TbCoupon.TbCouponService;
import com.hxh.services.TbDisCommRel.TbDisCommRelService;
import net.sf.json.JSONArray;
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
public class CouponAction extends BaseAction {


    private HttpServletRequest request = null;
    private HttpServletResponse response = null;

    private TbCouponService tbCouponService = null;

    public TbCouponService getTbCouponService() {
        return tbCouponService;
    }

    public void setTbCouponService(TbCouponService tbCouponService) {
        this.tbCouponService = tbCouponService;
    }

    /**
     * 查询优惠券列表
     * @return
     */
    public String queryCoupon() {

        request = getRequest();
        response = getResponse();

        String aoData = request.getParameter("aoData");

        JSONArray jsonarray = JSONArray.fromObject(aoData);


        int iDisplayStart = 0; // 起始索引
        int iDisplayLength = 10; // 每页显示的行数
        String sEcho = null;
        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject obj = (JSONObject) jsonarray.get(i);
            if (obj.get("name").equals("sEcho"))
                sEcho = obj.get("value").toString();
            if (obj.get("name").equals("iDisplayStart"))
                iDisplayStart = obj.getInt("value");
            if (obj.get("name").equals("iDisplayLength"))
                iDisplayLength = obj.getInt("value");
        }

        try {
            List<TbCommunity> list = tbCouponService.listAll();
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

  public String updateCoupon() {

        request = getRequest();
        response = getResponse();

        String aoData = request.getParameter("aoData");

        JSONArray jsonarray = JSONArray.fromObject(aoData);


        int iDisplayStart = 0; // 起始索引
        int iDisplayLength = 10; // 每页显示的行数
        String sEcho = null;
        for (int i = 0; i < jsonarray.size(); i++) {
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
   //         List<TbCommunity> list = tbCommunityService.queryFullComm(paramMap);
            JSONObject result = new JSONObject();
            result.put("sEcho", sEcho);
/*            result.put("iTotalRecords", list.size());//实际的行数
            result.put("iTotalDisplayRecords", list.size());//显示的行数
            result.put("aaData",list);*/
            print(response, result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

  public String delCoupon() {

        request = getRequest();
        response = getResponse();

        String aoData = request.getParameter("aoData");

        JSONArray jsonarray = JSONArray.fromObject(aoData);


        int iDisplayStart = 0; // 起始索引
        int iDisplayLength = 10; // 每页显示的行数
        String sEcho = null;
        for (int i = 0; i < jsonarray.size(); i++) {
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
   //         List<TbCommunity> list = tbCommunityService.queryFullComm(paramMap);
            JSONObject result = new JSONObject();
            result.put("sEcho", sEcho);
/*            result.put("iTotalRecords", list.size());//实际的行数
            result.put("iTotalDisplayRecords", list.size());//显示的行数
            result.put("aaData",list);*/
            print(response, result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}

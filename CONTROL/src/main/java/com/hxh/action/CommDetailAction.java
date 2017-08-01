package com.hxh.action;


import com.hxh.model.TbCommDetail;
import com.hxh.model.TbCommunity;
import com.hxh.services.TbCommDetail.TbCommDetailService;
import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2015/4/2.
 */
public class CommDetailAction extends BaseAction {


    private HttpServletRequest request = null;
    private HttpServletResponse response = null;

    private TbCommDetailService tbCommDetailService = null;

    public void setTbCommDetailService(TbCommDetailService tbCommDetailService) {
        this.tbCommDetailService = tbCommDetailService;
    }

    /**
     * 查询小区明细列表
     * @return
     */
    public String queryCommDetails() {

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
            String commId = request.getParameter("commId");
            String commDesc = request.getParameter("commDesc");

            TbCommDetail tbCommDetail = new TbCommDetail();
            tbCommDetail.setCommId(Integer.parseInt(commId));
            tbCommDetail.setCommDesc(commDesc);
            List<TbCommunity> list = tbCommDetailService.listCommDetail(tbCommDetail);
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
     * 添加小区详细地址
     * @return
     */
    public String addCommDetail() {
        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();
        try {
            String commId = request.getParameter("commId");
            String commDesc = request.getParameter("commDesc");
//            String commStatus = request.getParameter("commStatus");
            TbCommDetail tbCommDetail = new TbCommDetail();
            tbCommDetail.setCommId(Integer.parseInt(commId));
            tbCommDetail.setCommDesc(commDesc);
            tbCommDetail.setCommStatus(1);
            String id = tbCommDetailService.save(tbCommDetail);

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
     * 更新小区明细
     * @return
     */
    public String updateCommDetail() {
        request = getRequest();
        response = getResponse();
        JSONObject result = new JSONObject();

        try {
            String commId = request.getParameter("commId");
            String commDetailId = request.getParameter("commDetailId");
            String commDesc = request.getParameter("commDesc");
//            String commStatus = request.getParameter("commStatus");
            TbCommDetail tbCommDetail = new TbCommDetail();
            tbCommDetail.setCommId(Integer.parseInt(commId));
            tbCommDetail.setCommDetailId(Integer.parseInt(commDetailId));
            tbCommDetail.setCommDesc(commDesc);
            tbCommDetail.setCommStatus(1);

            boolean isUpdated = tbCommDetailService.update(tbCommDetail);

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
     * 删除小区明细
     * @return
     */
    public String deleteCommDetail() {
        request = getRequest();
        response = getResponse();
        JSONObject result = new JSONObject();

        try {
            String commDetailId = request.getParameter("commDetailId");
            String id = tbCommDetailService.deleteById(commDetailId);

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

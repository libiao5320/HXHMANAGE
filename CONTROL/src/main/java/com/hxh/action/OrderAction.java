package com.hxh.action;



import com.hxh.model.*;
import com.hxh.services.TbDiser.TbDiserService;
import com.hxh.services.TbOrder.TbOrderService;
import com.hxh.services.TbOrderProRel.TbOrderProRelService;
import com.hxh.services.TbOrderStatus.TbOrderStatusService;
import com.hxh.services.TbUser.TbUserService;
import com.hxh.util.FtpUtil;
import com.hxh.util.PropertiesUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.Exception;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/2.
 */
public class OrderAction extends BaseAction {


    private HttpServletRequest request = null;
    private HttpServletResponse response = null;


    private TbOrderService tbOrderService = null;
    private TbDiserService tbDiserService = null;
    private TbOrderProRelService tbOrderProRelService = null;
    private TbOrderStatusService tbOrderStatusService = null;
    private TbUserService tbUserService = null;




    private static PropertiesUtil pu = new PropertiesUtil("serverConfig.properties");


    public TbDiserService getTbDiserService() {
        return tbDiserService;
    }

    public void setTbDiserService(TbDiserService tbDiserService) {
        this.tbDiserService = tbDiserService;
    }

    public TbOrderProRelService getTbOrderProRelService() {
        return tbOrderProRelService;
    }

    public void setTbOrderProRelService(TbOrderProRelService tbOrderProRelService) {
        this.tbOrderProRelService = tbOrderProRelService;
    }

    public TbOrderStatusService getTbOrderStatusService() {
        return tbOrderStatusService;
    }

    public void setTbOrderStatusService(TbOrderStatusService tbOrderStatusService) {
        this.tbOrderStatusService = tbOrderStatusService;
    }

    public TbUserService getTbUserService() {
        return tbUserService;
    }

    public void setTbUserService(TbUserService tbUserService) {
        this.tbUserService = tbUserService;
    }

    public TbOrderService getTbOrderService() {
        return tbOrderService;
    }

    public void setTbOrderService(TbOrderService tbOrderService) {
        this.tbOrderService = tbOrderService;
    }





    public String queryOrdersByCondition(){



        JSONObject result = new JSONObject();

        request = getRequest();
        response = getResponse();

        String beginDate = request.getParameter("beginDate");
        String endDate = request.getParameter("endDate");
        String orderSeq = request.getParameter("orderSeq");
        String phone = request.getParameter("phone");


        Map params = new HashMap();
        params.put("beginDate",beginDate);
        params.put("endDate",endDate);
        params.put("orderSeq",orderSeq);
        params.put("phone",phone);



        String aoData = request.getParameter("aoData");
        JSONArray jsonarray = JSONArray.fromObject(aoData);


        int iDisplayStart = 0; // 起始索引
        int iDisplayLength = 10; // 每页显示的行数
        String sEcho = null;
        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject obj = (JSONObject) jsonarray.get(i);
            if (obj.get("name").equals("sEcho"))
                sEcho = obj.get("value").toString();

            iDisplayStart = obj.getInt("value");
            if (obj.get("name").equals("iDisplayStart"))

                if (obj.get("name").equals("iDisplayLength"))
                    iDisplayLength = obj.getInt("value");
        }
        try {

            List l = tbOrderService.manageListOrder(params);
//            JSONObject getObj = new JSONObject();
            result.put("sEcho", sEcho);
            result.put("iTotalRecords", l.size());//实际的行数
            result.put("iTotalDisplayRecords", l.size());//显示的行数

            result.put("aaData", l.subList(iDisplayStart,iDisplayStart + l.size()));
            print(response, result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }



        return null;

    }


    public String queryOrders() {

        JSONObject result = new JSONObject();

        request = getRequest();
        response = getResponse();
        String type = request.getParameter("type");








        String aoData = request.getParameter("aoData");
        JSONArray jsonarray = JSONArray.fromObject(aoData);


        int iDisplayStart = 0; // 起始索引
        int iDisplayLength = 10; // 每页显示的行数
        String sEcho = null;
        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject obj = (JSONObject) jsonarray.get(i);
            if (obj.get("name").equals("sEcho"))
                sEcho = obj.get("value").toString();

            iDisplayStart = obj.getInt("value");
            if (obj.get("name").equals("iDisplayStart"))

            if (obj.get("name").equals("iDisplayLength"))
                iDisplayLength = obj.getInt("value");
        }
        try {

            List l = tbOrderService.manageListOrder(type);
//            JSONObject getObj = new JSONObject();
            result.put("sEcho", sEcho);
            result.put("iTotalRecords", l.size());//实际的行数
            result.put("iTotalDisplayRecords", l.size());//显示的行数

            result.put("aaData", l.subList(iDisplayStart,iDisplayStart + l.size()));
            print(response, result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }



    public String delOrder(){



        JSONObject result = new JSONObject();

        request = getRequest();
        response = getResponse();

        String orderId = request.getParameter("orderId");
        try {
            boolean flag  = tbOrderService.delOrder(orderId);


            result.put("success", true);
            result.put("flag", flag);


            print(response, result.toString());
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }




    public String palyVoiceFromFtp()
    {



        request =getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();
        try {

        String voicePath = pu.getValue("voicePath");
        String realPath = request.getSession().getServletContext().getRealPath("/")+voicePath;

        String fileName = request.getParameter("fileName");
        boolean exisFlag = FtpUtil.downFile(fileName, realPath);

        result.put("voicePath", voicePath + fileName);


            print(response,result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;

    }


    public String queryOrderDetail(){


        request = getRequest();
        response = getResponse();
        String orderId = request.getParameter("orderId");

        try {



            JSONObject result = new JSONObject();

            Map orderMap =tbOrderService.queryOrderDetail(orderId);
            Integer userId = (Integer) orderMap.get("userId");
            Integer disId = (Integer) orderMap.get("disId");

            TbUser tbUser = tbUserService.queryById(""+userId);

            result.put("orderInfo", orderMap);
            result.put("userInfo", tbUser);
            List<Map<String, String>> proList = tbOrderProRelService.queryProductListByOrderId(orderId);
            result.put("proList", proList);

            List<TbOrderStatus> statusList = tbOrderStatusService.queryStatusListByOrderId(orderId);
            result.put("statusList", statusList);

            TbDiser tbDiser = tbDiserService.queryById("" + disId);
            result.put("tbDiser", tbDiser);





            print(response, result.toString());
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }





    public String addCurentStatusDesc(){

        request = getRequest();
        response = getResponse();
        String orderId = request.getParameter("orderId");
        String orderStatusDesc = request.getParameter("staDesc");

        try {



            JSONObject result = new JSONObject();
            TbOrder  tbOrder  = tbOrderService.queryById(orderId);
            TbOrderStatus orderStatus = tbOrderStatusService.queryById("" + tbOrder.getOrderStatus());


            orderStatus.setOrderDesc(orderStatusDesc);
            boolean flag = tbOrderStatusService.update(orderStatus);


            result.put("flag",flag);
            result.put("success",true);
            print(response,result.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public String checkOrder()
    {


        request = getRequest();
        response = getResponse();

        String orderId = request.getParameter("orderId");
        String products = request.getParameter("products");
        String chkId = request.getParameter("chkId");


        List   proList  = new ArrayList();
        String [] productArr = products.split(",");

        try {
            TbOrder order = tbOrderService.queryById(orderId);



        for(int i =0 ; i <productArr.length;i++)
        {

            String s = productArr[i];
            String []  ss  = s.split("|");
            for(int j  = 0  ; j < ss.length;j++)
            {
                TbOrderProRel proRel = new TbOrderProRel();
                proRel.setProId(Integer.parseInt(orderId));
                proRel.setCount(Integer.parseInt(ss[0]));
                proRel.setProId(Integer.parseInt(ss[1]));
                proList.add(proRel);

            }





        }

        tbOrderService.checkOrder(proList,order,chkId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }






    public String makeOrder(){

        request = getRequest();
        response = getResponse();


        return null;

    }




}

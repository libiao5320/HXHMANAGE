package com.hxh.action;

import com.hxh.model.TbProduct;
import com.hxh.model.TbProductAttr;
import com.hxh.model.TbProductType;
import com.hxh.services.TbProduct.TbProductService;
import com.hxh.services.TbProductType.TbProductTypeService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/5/8.
 */
public class ProductAction extends BaseAction {


    private HttpServletRequest request = null;
    private HttpServletResponse response = null;


    private TbProductService tbProductService = null;
    private TbProductTypeService tbProductTypeService = null;


    public void setTbProductService(TbProductService tbProductService) {
        this.tbProductService = tbProductService;
    }


    public void setTbProductTypeService(TbProductTypeService tbProductTypeService) {
        this.tbProductTypeService = tbProductTypeService;
    }

    public String initProductList() {
        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();


        String aoData = request.getParameter("aoData");
        JSONArray jsonarray = JSONArray.fromObject(aoData);


        int iDisplayStart = 0; // ��ʼ����
        int iDisplayLength = 10; // ÿҳ��ʾ������
        String sEcho = null;
        for (int i = 0; i < jsonarray.size(); i++) {

            if(jsonarray.get(i).getClass().getName().equals("net.sf.json.JSONNull"))
            break;

            JSONObject obj = (JSONObject) jsonarray.get(i);
            if (obj.get("name").equals("sEcho"))
                sEcho = obj.get("value").toString();

            iDisplayStart = obj.getInt("value");
            if (obj.get("name").equals("iDisplayStart"))

                if (obj.get("name").equals("iDisplayLength"))
                    iDisplayLength = obj.getInt("value");
        }

        try {

            List l = tbProductService.manageProList();

//            JSONObject getObj = new JSONObject();
            result.put("sEcho", sEcho);
            result.put("iTotalRecords", l.size());//ʵ�ʵ�����
            result.put("iTotalDisplayRecords", l.size());//��ʾ������

            result.put("aaData", l.subList(iDisplayStart, iDisplayStart + l.size()));
            print(response, result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;


    }


    public String initAllProType() {


        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();


//            List typeList = tbProductService.queryAllProType();
//            result.put("typeList", typeList);
//
//            print(response, result.toString());

        String aoData = request.getParameter("aoData");
        JSONArray jsonarray = JSONArray.fromObject(aoData);


        int iDisplayStart = 0; // ��ʼ����
        int iDisplayLength = 10; // ÿҳ��ʾ������
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

            List typeList = tbProductService.queryAllProType();


            result.put("sEcho", sEcho);
            result.put("iTotalRecords", typeList.size());//ʵ�ʵ�����
            result.put("iTotalDisplayRecords", typeList.size());//��ʾ������

            result.put("aaData", typeList.subList(iDisplayStart, iDisplayStart + typeList.size()));
            result.put("typeList", typeList);
            print(response, result.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }


    public String queryProduct() {


        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();

        try {

            String proId  = request.getParameter("proId");
            TbProduct product = tbProductService.queryById(proId);

            result.put("success",true);
            result.put("product",product);

            print(response,result.toString());


        } catch (Exception e) {


        e.printStackTrace();


        }

    return null;
    }


    public String queryAttrById()
    {

        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();

        String attrId = request.getParameter("attrId");


        try {
            TbProductAttr productAttr = tbProductService.queryAttrById(attrId);

            result.put("productAttr",productAttr);
            result.put("flag",true);
            print(response,result.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }


    public String queryProductType() {


        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();

        try {

            String  typeId = request.getParameter("typeId");
            TbProductType productType = tbProductTypeService.queryById(typeId);

            result.put("success",true);
            result.put("productType", productType);

            print(response,result.toString());


        } catch (Exception e) {


            e.printStackTrace();


        }

        return null;
    }


    public String editProduct() {


        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();


        String proId = request.getParameter("proId");
        String proName = request.getParameter("proName");
        String price = request.getParameter("price");
        String realPrice = request.getParameter("realPrice");
        String typeId = request.getParameter("typeId");
        String status = request.getParameter("status");
        String unit  = request.getParameter("unit");
        try {
            TbProduct product = tbProductService.queryById(proId);

            if (null != proName && !"".equals(proName))
                product.setProName(proName);
            if (null != price && !"".equals(price))
                product.setProPrice(Double.valueOf(price));
            if (null != realPrice && !"".equals(realPrice))
                product.setProRealprice(Double.valueOf(realPrice));
            if (null != typeId && !"".equals(typeId))
                product.setTypeId(Integer.valueOf(typeId));
            if (null != status && !"".equals(status))
                product.setProStatus(Integer.valueOf(status));
            if(null !=  unit && !"".equals(unit))
                product.setProUnit(unit);

            boolean flag = tbProductService.update(product);


            result.put("success",true);
            result.put("flag",flag);

            print(response,result.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }



    public String editProType()
    {

        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();


        String typeId = request.getParameter("typeId");
        String typeName = request.getParameter("typeName");
        String status  = request.getParameter("status");


        try {
            TbProductType productType = tbProductTypeService.queryById(typeId);

            if (null != typeName && !"".equals(typeName))
                productType.setTypeName(typeName);
            if (null != status && !"".equals(status))
                productType.setTypeStatus(Integer.valueOf(status));


            boolean flag = tbProductTypeService.update(productType);


            result.put("success",true);
            result.put("flag",flag);

            print(response,result.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public String queryProductByCondition() {

        JSONObject result = new JSONObject();

        request = getRequest();
        response = getResponse();

        String typeId = request.getParameter("typeId");



        String proName = request.getParameter("proName");


        Map params = new HashMap();
        params.put("proName", proName);
        params.put("typeId", typeId);


        String aoData = request.getParameter("aoData");
        JSONArray jsonarray = JSONArray.fromObject(aoData);


        int iDisplayStart = 0; // ��ʼ����
        int iDisplayLength = 10; // ÿҳ��ʾ������
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

            List l = tbProductService.queryProductByCondition(params);
//            JSONObject getObj = new JSONObject();
            result.put("sEcho", sEcho);
            result.put("iTotalRecords", l.size());//ʵ�ʵ�����
            result.put("iTotalDisplayRecords", l.size());//��ʾ������

            result.put("aaData", l.subList(iDisplayStart, iDisplayStart + l.size()));
            print(response, result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;

    }



    public String delProType() {
        JSONObject result = new JSONObject();

        request = getRequest();
        response = getResponse();

        String type = request.getParameter("typeId");
        try {
            String delId = tbProductTypeService.deleteById(type);


            result.put("success", true);
            result.put("flag", delId);


            print(response, result.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public String delPro() {

        JSONObject result = new JSONObject();

        request = getRequest();
        response = getResponse();

        String proId = request.getParameter("proId");
        try {
            String delId = tbProductService.deleteById(proId);


            result.put("success", true);
            result.put("flag", delId);


            print(response, result.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public String queryProAttr() {


        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();


        String proId = request.getParameter("proId");
        String aoData = request.getParameter("aoData");
        JSONArray jsonarray = JSONArray.fromObject(aoData);

        int iDisplayStart = 0; // ��ʼ����
        int iDisplayLength = 10; // ÿҳ��ʾ������
        String sEcho = null;
        for (int i = 0; i < jsonarray.size(); i++) {

            if(jsonarray.get(i).getClass().getName().equals("net.sf.json.JSONNull"))
                break;

            JSONObject obj = (JSONObject) jsonarray.get(i);



            if (obj.get("name").equals("sEcho"))
                sEcho = obj.get("value").toString();

            iDisplayStart = obj.getInt("value");
            if (obj.get("name").equals("iDisplayStart"))

                if (obj.get("name").equals("iDisplayLength"))
                    iDisplayLength = obj.getInt("value");
        }

        try {

            List l = tbProductService.queryAttrByProId(proId);
//            JSONObject getObj = new JSONObject();
            result.put("sEcho", sEcho);
            result.put("iTotalRecords", l.size());//ʵ�ʵ�����
            result.put("iTotalDisplayRecords", l.size());//��ʾ������

            result.put("aaData", l.subList(iDisplayStart, iDisplayStart + l.size()));
            print(response, result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;

    }



    public String addProAttr()
    {




        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();


        String proId = request.getParameter("proId");
        String attName = request.getParameter("attrName");


        TbProductAttr attr = new TbProductAttr();
        attr.setProId(Integer.valueOf(proId));
        attr.setAttrName(attName);

        try {
            String id  = tbProductService.addProAttr(attr);

            result.put("flag",null == id?false:true);
            result.put("success",true);


            print(response,result.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }


    public String editProAttr()
    {


        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();


        String attrId = request.getParameter("attrId");
        String attName = request.getParameter("attrName");


        TbProductAttr attr = new TbProductAttr();
        attr.setAttrId(Integer.valueOf(attrId));
        attr.setAttrName(attName);

        try {
            boolean flag  = tbProductService.editProAttr(attr);

            result.put("flag",flag);
            result.put("success",true);


            print(response,result.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }



    public String delProAttr()
    {


        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();


        String attrId = request.getParameter("attrId");





        try {
            boolean flag  = tbProductService.delProAttr(attrId);

            result.put("flag",flag);
            result.put("success",true);


            print(response,result.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }


    public String initProductType() {


        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();


        String aoData = request.getParameter("aoData");
        JSONArray jsonarray = JSONArray.fromObject(aoData);

        int iDisplayStart = 0; // ��ʼ����
        int iDisplayLength = 10; // ÿҳ��ʾ������
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

            List l = tbProductService.manageProTypeList();
//            JSONObject getObj = new JSONObject();
            result.put("sEcho", sEcho);
            result.put("iTotalRecords", l.size());//ʵ�ʵ�����
            result.put("iTotalDisplayRecords", l.size());//��ʾ������

            result.put("aaData", l.subList(iDisplayStart, iDisplayStart + l.size()));
            print(response, result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }


    public String addProduct() {


        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();


        String proName = request.getParameter("proName");
        String price = request.getParameter("price");
        String realprice = request.getParameter("realprice");
        String type = request.getParameter("type");
        String unit = request.getParameter("unit");


        TbProduct product = new TbProduct();
        product.setProName(proName);
        product.setProPrice(Double.valueOf(price));
        product.setProRealprice(Double.valueOf(realprice));
        product.setTypeId(Integer.valueOf(type));
        product.setProStatus(1);
        product.setProUnit(unit);

        try {
            String productId = tbProductService.save(product);

            boolean flag = false;
            if (null != productId)
                flag = true;
            result.put("success", true);

            result.put("flag", flag);

            print(response, result.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }


    public String addProductType() {

        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();


        String typeName = request.getParameter("typeName");


        TbProductType productType = new TbProductType();


        productType.setTypeName(typeName);
        productType.setTypeParent(-1);
        productType.setTypeStatus(1);

        try {
            String typeId = tbProductTypeService.save(productType);

            boolean flag = false;
            if (null != typeId)
                flag = true;
            result.put("success", true);

            result.put("flag", flag);

            print(response, result.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }


}

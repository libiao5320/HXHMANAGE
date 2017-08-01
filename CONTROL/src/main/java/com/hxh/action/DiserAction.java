package com.hxh.action;


import com.hxh.model.TbCommunity;
import com.hxh.model.TbDisCommRel;
import com.hxh.model.TbDiser;
import com.hxh.model.TbRegional;
import com.hxh.services.TbCommunity.TbCommunityService;
import com.hxh.services.TbDisCommRel.TbDisCommRelService;
import com.hxh.services.TbDiser.TbDiserService;
import com.hxh.services.TbRegional.TbRegionalService;
import com.hxh.util.MapUtil;
import com.hxh.util.PropertiesUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2015/4/2.
 */
public class DiserAction extends BaseAction {
    private static final String CONTENT_TYPE = "text/html; charset=GB2312";


    //    ServletContext sc = (ServletContext) ActionContext.getContext().get(ServletActionContext.SERVLET_CONTEXT);
//    String temp = ServletActionContext.getRequest().getRealPath("/");
    private static final String UPLOAD_PATH = ServletActionContext.getRequest().getRealPath("/") + "/Upload/images/";
    private static final int BUF_SIZE = 8192;

    private HttpServletRequest request = null;
    private HttpServletResponse response = null;


    private TbDiserService tbDiserService = null;
    private TbCommunityService tbCommunityService = null;
    private TbDisCommRelService tbDisCommRelService = null;
    private TbRegionalService tbRegionalService = null;
    private static PropertiesUtil pu = new PropertiesUtil("serverConfig.properties");

    public TbRegionalService getTbRegionalService() {
        return tbRegionalService;
    }

    public void setTbRegionalService(TbRegionalService tbRegionalService) {
        this.tbRegionalService = tbRegionalService;
    }

    public TbDiserService getTbDiserService() {
        return tbDiserService;
    }

    public void setTbDiserService(TbDiserService tbDiserService) {
        this.tbDiserService = tbDiserService;
    }

    public TbCommunityService getTbCommunityService() {
        return tbCommunityService;
    }

    public void setTbCommunityService(TbCommunityService tbCommunityService) {
        this.tbCommunityService = tbCommunityService;
    }

    public TbDisCommRelService getTbDisCommRelService() {
        return tbDisCommRelService;
    }

    public void setTbDisCommRelService(TbDisCommRelService tbDisCommRelService) {
        this.tbDisCommRelService = tbDisCommRelService;
    }


    public String queryDiserByCondition(){
        JSONObject result = new JSONObject();
        request = getRequest();
        response = getResponse();

        String workNum = request.getParameter("workNum");
        String diserName = request.getParameter("diserName");
        String phone = request.getParameter("phone");


        Map params = new HashMap();
        params.put("workNum",workNum);
        params.put("diserName",diserName);
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

            List<TbDiser> l = tbDiserService.manageListDiser(params);

            List<Map> listMap = new ArrayList<Map>();
            for(int i=0;i<l.size();i++){
                Map map = new HashMap();
                map.put("disId",l.get(i).getDisId());
                map.put("workNum" ,l.get(i).getDisWorknum());
                map.put("disPhoto", l.get(i).getDisPhoto());
                map.put("disPhone", l.get(i).getDisPhone());
                map.put("disName",l.get(i).getDisName());
                map.put("disStatus", l.get(i).getDisStatus() == null ? "" : l.get(i).getDisStatus().toString());
/*                map.put("edit", "edit");
                map.put("delete", "delete");*/
                listMap.add(i, map);
            }
            JSONObject getObj = new JSONObject();
            result.put("sEcho", sEcho);
            //    result.put("iTotalRecords", l.size());//实际的行数
            //   result.put("iTotalDisplayRecords", l.size());//显示的行数

            result.put("aaData", listMap.subList(iDisplayStart, iDisplayStart + listMap.size()));
            print(response, result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public String queryDiser() {
        JSONObject result = new JSONObject();

        request = getRequest();
        response = getResponse();
        String type = request.getParameter("type");
        String aoData = request.getParameter("aoData");
        JSONArray jsonarray = JSONArray.fromObject(aoData);

        int iDisplayStart = 0; // 起始索引
        int iDisplayLength = 10; // 每页显示的行数
        String sEcho = null;
/*        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject obj = (JSONObject) jsonarray.get(i);
            if (obj.get("name").equals("sEcho"))
                sEcho = obj.get("value").toString();

            iDisplayStart = obj.getInt("value");
            if (obj.get("name").equals("iDisplayStart"))

                if (obj.get("name").equals("iDisplayLength"))
                    iDisplayLength = obj.getInt("value");
        }*/
        try {
            List<TbDiser> l = tbDiserService.listAll();

            List<Map<String,String>> listMap = new ArrayList<Map<String,String>>();
            for(int i=0;i<l.size();i++){
                Map<String,String> map = new HashMap<String, String>();
                map.put("disId",l.get(i).getDisId().toString());
                map.put("workNum" ,l.get(i).getDisWorknum());
                map.put("disPhoto", l.get(i).getDisPhoto());
                map.put("disPhone", l.get(i).getDisPhone());
                map.put("disName",l.get(i).getDisName());
                map.put("disStatus", l.get(i).getDisStatus() == null ? "" : l.get(i).getDisStatus().toString());
/*                map.put("edit", "edit");
                map.put("delete", "delete");*/
                listMap.add(i, map);
            }
          JSONObject getObj = new JSONObject();
            result.put("sEcho", sEcho);
            //    result.put("iTotalRecords", l.size());//实际的行数
            //   result.put("iTotalDisplayRecords", l.size());//显示的行数

            result.put("aaData", listMap.subList(iDisplayStart, iDisplayStart + listMap.size()));
            print(response, result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String queryCommByDisId() {
        JSONObject result = new JSONObject();

        request = getRequest();
        response = getResponse();
        String disId = request.getParameter("type");
        String aoData = request.getParameter("aoData");
        JSONArray jsonarray = JSONArray.fromObject(aoData);

        int iDisplayStart = 0; // 起始索引
        int iDisplayLength = 10; // 每页显示的行数
        String sEcho = null;
/*        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject obj = (JSONObject) jsonarray.get(i);
            if (obj.get("name").equals("sEcho"))
                sEcho = obj.get("value").toString();

            iDisplayStart = obj.getInt("value");
            if (obj.get("name").equals("iDisplayStart"))

                if (obj.get("name").equals("iDisplayLength"))
                    iDisplayLength = obj.getInt("value");
        }*/
        List<Map<String,String>> listMap = new ArrayList<Map<String,String>>();
        try {

            List<TbDisCommRel> tbDisCommRelList = tbDisCommRelService.getByDisId(disId);
            for(int i=0;i<tbDisCommRelList.size(); i++){
                TbDisCommRel rel = tbDisCommRelList.get(i);
                TbCommunity disComm = tbCommunityService.queryById(rel.getCommId().toString());
                TbRegional tbRegional = tbRegionalService.queryById(String.valueOf(disComm.getRegionalId()));
                    Map<String,String> map = new HashMap<String, String>();
                    map.put("commId",disComm.getCommId().toString());
                    map.put("disCity" ,tbRegional.getRegionalName());
                    map.put("disComm" ,disComm.getCommName());

                    listMap.add(i, map);

            }

          JSONObject getObj = new JSONObject();
            result.put("sEcho", sEcho);
            //    result.put("iTotalRecords", l.size());//实际的行数
            //   result.put("iTotalDisplayRecords", l.size());//显示的行数

            result.put("aaData", listMap.subList(iDisplayStart, iDisplayStart + listMap.size()));
            print(response, result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public String delCommRel() {
        JSONObject result = new JSONObject();

        request = getRequest();
        response = getResponse();
        String commId = request.getParameter("commId");
        String disId = request.getParameter("disId");
        try {
            tbDisCommRelService.delCommRel(disId, commId);
            result.put("resultCode", 1);
            try {
                print(response, result.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            result.put("resultCode", 0);
            try {
                print(response, result.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

        return null;
    }

    public String addDiser(){

        JSONObject result = new JSONObject();
        request = getRequest();
        response = getResponse();
        TbDiser tbDiser = new TbDiser();
        //tbDiser.setDisId(Integer.parseInt(request.getParameter("disId")));
       // tbDiser.setDisWorknum(request.getParameter("workNum"));
        tbDiser.setDisPhone(request.getParameter("disPhone"));
        tbDiser.setDisName(request.getParameter("disName"));
        tbDiser.setDisPhoto(request.getParameter("fileNameAdd"));
        //初始时设置状态为启用
        tbDiser.setDisStatus(1);

        try {
            tbDiserService.saveDiser(tbDiser,UPLOAD_PATH);
            result.put("resultCode", 1);
            print(response, result.toString());

        } catch (Exception e) {
            result.put("resultCode", 0);
            try {
                print(response, result.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }


    public String relComm(){

        JSONObject result = new JSONObject();
        request = getRequest();
        response = getResponse();
        String disId = request.getParameter("disId");
        String str = request.getParameter("str");
        try {
            tbDiserService.relComm(disId, str);
            result.put("resultCode", 1);
            print(response, result.toString());
        } catch (Exception e) {
            result.put("resultCode", 0);
            try {
                print(response, result.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }

    public String diserFileUpload(){

            JSONObject result = new JSONObject();
        File directory = new File(UPLOAD_PATH);
        File uploadPath  = new File(ServletActionContext.getRequest().getRealPath("/")+"/Upload");
        HttpServletResponse response = getResponse();
            response.setContentType(CONTENT_TYPE);

            if (!uploadPath.exists())
                uploadPath.mkdir();
            if (!directory.exists())
                directory.mkdir();

            try {
                MultiPartRequestWrapper mpRequest = (MultiPartRequestWrapper) getRequest();
                String fileName = mpRequest.getParameter("fileName");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                Date date=new Date();
                String time =  sdf.format(date);
                fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                fileName = new String(fileName.getBytes("gbk"),"utf-8");
                File[] uploadFile = mpRequest.getFiles("fileUp");
                File file = null;
                if (null != uploadFile && uploadFile.length > 0)
                    file = uploadFile[0];
                fileName  = time+fileName.substring(fileName.indexOf("."));
                final File outFile = new File(UPLOAD_PATH, fileName);
                if (outFile.exists()) {

                    fileName = "exist";
                    outFile.delete();
                }
                final OutputStream outputStream = new FileOutputStream(outFile);
                BufferedInputStream bufferedInputStream = null;
                BufferedOutputStream bufferedOutputStream = null;
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    bufferedOutputStream = new BufferedOutputStream(outputStream);

                    final byte temp[] = new byte[BUF_SIZE];
                    int readBytes = 0;
                    while ((readBytes = bufferedInputStream.read(temp)) != -1) {
                        bufferedOutputStream.write(temp, 0, readBytes);
                    }
                    bufferedOutputStream.flush();

                } finally {
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
//                formFile.destroy();
                }
                result.put("success", true);
                result.put("fileName", fileName);
      ///          result.put("fileNamePath", outFile.getPath());
                print(response, result.toString());


            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    public String diserFileUploadAdd(){

        JSONObject result = new JSONObject();
        File directory = new File(UPLOAD_PATH);
        File uploadPath  = new File(ServletActionContext.getRequest().getRealPath("/")+"/Upload");
        HttpServletResponse response = getResponse();
        response.setContentType(CONTENT_TYPE);

        if (!uploadPath.exists())
            uploadPath.mkdir();
        if (!directory.exists())
            directory.mkdir();
        try {
            MultiPartRequestWrapper mpRequest = (MultiPartRequestWrapper) getRequest();
            String fileName = mpRequest.getParameter("fileName");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date=new Date();
            String time =  sdf.format(date);
            fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
            fileName = new String(fileName.getBytes("gbk"),"utf-8");
            File[] uploadFile = mpRequest.getFiles("fileUpAdd");
            File file = null;
            if (null != uploadFile && uploadFile.length > 0)
                file = uploadFile[0];
            fileName  = time+fileName.substring(fileName.indexOf("."));
            final File outFile = new File(UPLOAD_PATH, fileName);
            if (outFile.exists()) {

                fileName = "exist";
                outFile.delete();
            }
            final OutputStream outputStream = new FileOutputStream(outFile);
            BufferedInputStream bufferedInputStream = null;
            BufferedOutputStream bufferedOutputStream = null;
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                bufferedOutputStream = new BufferedOutputStream(outputStream);

                final byte temp[] = new byte[BUF_SIZE];
                int readBytes = 0;
                while ((readBytes = bufferedInputStream.read(temp)) != -1) {
                    bufferedOutputStream.write(temp, 0, readBytes);
                }
                bufferedOutputStream.flush();

            } finally {
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
//                formFile.destroy();
            }
            result.put("success", true);
            result.put("fileName", fileName);
            ///          result.put("fileNamePath", outFile.getPath());
            print(response, result.toString());


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deleteDiser(){
        JSONObject result = new JSONObject();
        request = getRequest();
        response = getResponse();
        String disId = request.getParameter("disId");
        try {
            tbDiserService.deleteById(disId,UPLOAD_PATH);
            result.put("resultCode", 1);
            print(response, result.toString());
        } catch (Exception e) {
            result.put("resultCode", 0);
            try {
                print(response, result.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }


    public String queryDiserById(){
        JSONObject result = new JSONObject();
        request = getRequest();
        response = getResponse();
        String disId = request.getParameter("disId");
        try {
            TbDiser tbDiser =  tbDiserService.queryById(disId);
            result.put("disName", tbDiser.getDisName());
            result.put("resultCode", 1);
            print(response, result.toString());
        } catch (Exception e) {
            result.put("resultCode", 0);
            try {
                print(response, result.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }

    public String updateDiser() {

        JSONObject result = new JSONObject();
        request = getRequest();
        response = getResponse();
        TbDiser tbDiser22 = null;
        TbDiser tbDiser = new TbDiser();
        tbDiser.setDisId(Integer.parseInt(request.getParameter("disId")));
        tbDiser.setDisName(request.getParameter("disName"));
        tbDiser.setDisPhone(request.getParameter("disPhone"));
        tbDiser.setDisWorknum(request.getParameter("workNum"));
        tbDiser.setDisStatus(Integer.parseInt(request.getParameter("disStatus")));
        if(request.getParameter("fileName")!=null&&"".equals(request.getParameter("fileName"))==false){
            tbDiser.setDisPhoto(request.getParameter("fileName"));
        }else{
            try {
                tbDiser22 = tbDiserService.queryById(request.getParameter("disId"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            tbDiser.setDisPhoto(tbDiser22.getDisPhoto());
        }
        try {
           boolean b = tbDiserService.update(tbDiser, UPLOAD_PATH);
            if(b==false){
                result.put("resultCode",0);
            }else{
                result.put("resultCode", 1);
            }
            print(response, result.toString());
        } catch (Exception e) {
            result.put("resultCode", 0);
            try {
                print(response, result.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

      /*
        if(request.getParameter("fileName")!=null&&"".equals(request.getParameter("fileName"))==false){
            tbDiser.setDisPhoto(request.getParameter("fileName"));
            try {
                tbDiserService.update(tbDiser,UPLOAD_PATH);
                result.put("resultCode", 1);
                print(response, result.toString());
            } catch (Exception e) {
                result.put("resultCode", 0);
                try {
                    print(response, result.toString());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
        }else{

            try {
                tbDiser22 = tbDiserService.queryById(request.getParameter("disId"));
                tbDiser.setDisPhoto(tbDiser22.getDisPhoto());
                tbDiserService.update(tbDiser);
                result.put("resultCode", 1);
                print(response, result.toString());
            } catch (Exception e) {
                result.put("resultCode", 0);
                try {
                    print(response, result.toString());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
        }*/
        return null;
    }

    public String queryDiserList() {


        request = getRequest();
        response = getResponse();

        try {
            Map paramMap = MapUtil.getParameterMap(request);
            JSONObject result = new JSONObject();
            List<TbDiser> l = tbDiserService.manageListDiser(paramMap);
            result.put("results", l);
            print(response, result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

package com.hxh.action;


import com.hxh.model.TbCommunity;
import com.hxh.services.TbRegional.TbRegionalService;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2015/4/2.
 */
public class RegionalAction extends BaseAction {


    private HttpServletRequest request = null;
    private HttpServletResponse response = null;

    private TbRegionalService tbRegionalService = null;

    public void setTbRegionalService(TbRegionalService tbRegionalService) {
        this.tbRegionalService = tbRegionalService;
    }

    /**
     * 查询地域列表
     * @return
     */
    public String queryRegionals() {

        request = getRequest();
        response = getResponse();
        JSONObject result = new JSONObject();
        try {
            String parentId = request.getParameter("parentId");
            List<TbCommunity> list = tbRegionalService.listRegional(parentId);

            result.put("resultCode",1);
            result.put("regionalList",list);
            print(response, result.toString());
        } catch (Exception e) {
            result.put("resultCode",2);
            try {
                print(response, result.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询同级地域列表
     * @return
     */
    public String queryRelateRegionals() {

        request = getRequest();
        response = getResponse();
        JSONObject result = new JSONObject();
        try {
            String regId = request.getParameter("regId");
            List<TbCommunity> list = tbRegionalService.listRelateRegional(regId);

            result.put("resultCode",1);
            result.put("regionalList",list);
            print(response, result.toString());
        } catch (Exception e) {
            result.put("resultCode",2);
            try {
                print(response, result.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }



}

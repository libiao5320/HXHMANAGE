package com.hxh.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2015/4/2.
 */
public class IndexAction extends BaseAction {

    private String pageFlag = null;


    private HttpServletRequest request = null;
    private HttpServletResponse response = null;

    public String getPageFlag() {
        return pageFlag;
    }

    public void setPageFlag(String pageFlag) {
        this.pageFlag = pageFlag;
    }

    public String setStrutsPage(){

        request = getRequest();
        HttpSession session = request.getSession();
        pageFlag = request.getParameter("pageFlag");




        return "pageFlag";
    }

}

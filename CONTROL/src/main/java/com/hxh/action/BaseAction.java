package com.hxh.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/2.
 */
public class BaseAction extends ActionSupport implements RequestAware {
    protected final static String CREATED_SUCCESS = "创建成功";
    protected final static String UPDATE_SUCCESS = "更新成功";
    protected final static String DELETE_SUCCESS = "删除成功";
    private final String CONTENT_TYPE = "text/plain; charset=UTF-8";

    protected Map requestMap = null;



    public void setRequest(Map request) {
        this.requestMap = request;
    }

    public HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }


    public HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }


    public void print(HttpServletResponse response, String content) throws IOException {
        response.setContentType(CONTENT_TYPE);
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        PrintWriter write = response.getWriter();
        write.print(content);
        write.close();
    }



}

package com.hxh.dao.Base.impl;



/***********************************************************************
 * Module:  BaseDaoImpl.java
 * Author:  Administrator
 * Purpose: Defines the Class BaseDaoImpl
 ***********************************************************************/

import com.hxh.dao.Base.BaseDao;
import com.hxh.model.BaseEntity;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.util.ClassUtils;

import java.sql.SQLException;
import java.util.List;


public abstract class BaseDaoImpl<T extends BaseEntity> extends SqlMapClientDaoSupport implements BaseDao<T> {




    protected final String OP_INSERT = ".insert";//新增数据方法
    protected final String OP_DELETE = ".delete";//根据对象删除该数据（主键删除）
    protected final String OP_UPDATE = ".update";//将对象中不为空的字段进行更新，根据主键更新
    protected final String OP_GETBYID = ".getById";//根据model对象t中包含的主键提取全部数据至t中
    protected final String OP_QUERYALL = ".queryAll";//根据model对象t中的数据查询满足对应条件的所有数据列表 ,可增加排序条件




    public String save(String statementName,T model) throws SQLException {



        Object id = getSqlMapClient().insert(statementName, model);
        if(null != id ){
            return ""+id;
        }
        return  null;
    }


    public boolean update(String statementName,T model) throws SQLException {



        if(getSqlMapClient().update(statementName, model)>0){
            return true;
        }
        return false;

    }


    public String deleteById(String statementName,String id) throws SQLException {

//		String statementName = getNamespace(model) + OP_DELETE;
        if(getSqlMapClient().delete(statementName, id)>0){
            return id;
        }
        return null;

    }


    public T queryById(String statementName,String id) throws SQLException {

        T result = null;
        result = (T) getSqlMapClient().queryForObject(statementName, id);
        return result;
    }


    public List listAll(String statementName) throws SQLException {
        List list=null;
        list= (List)getSqlMapClient().queryForList(statementName);
        return list;
    }


    protected String getNamespace(Object model) {
        String objStr=ClassUtils.getShortNameAsProperty(model.getClass());
        return objStr.substring(0,1).toUpperCase() + objStr.substring(1,objStr.lastIndexOf("D"));
    }


}
/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.dao.TbCommunity;


import com.hxh.dao.Base.BaseDao;
import com.hxh.model.TbCommunity;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TbCommunityDao extends BaseDao<TbCommunity> {
    /**
     * 根据指定地域，查询小区列表，有关键字时，做模糊匹配
     * @param model 地域ID，小区名称
     * @return 小区列表
     * @throws Exception 异常
     */
    public List listRegComm(TbCommunity model) throws SQLException;

    /**
     * 模糊匹配小区列表，显示小区省市区
     * @param searchValue 查询名称
     * @return 小区列表
     * @throws Exception 异常
     */
    public List queryFullComm(Map searchValue) throws SQLException;

    public List queryNearComm(HashMap map) throws SQLException;

    public Map<String,String> getCommunityById(String commId) throws SQLException;
}

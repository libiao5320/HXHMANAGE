/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.dao.TbDiser;


import com.hxh.dao.Base.BaseDao;
import com.hxh.model.TbDiser;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface TbDiserDao extends BaseDao<TbDiser> {
	
	public boolean goodDiser(String disId) throws SQLException;

    public boolean badDiser(String disId) throws SQLException;

    public List manageListDiser(Map param) throws SQLException;
}

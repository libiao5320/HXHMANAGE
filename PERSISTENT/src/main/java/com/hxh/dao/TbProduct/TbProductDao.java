/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.dao.TbProduct;


import com.hxh.dao.Base.BaseDao;
import com.hxh.model.TbProduct;
import com.hxh.model.TbProductAttr;
import com.ibatis.sqlmap.engine.mapping.sql.Sql;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface TbProductDao extends BaseDao<TbProduct> {
	
	    public List getPriceList() throws SQLException;
		public List mangeProList() throws SQLException;
		public List mangeProTypeList() throws SQLException;
		public List queryAttrByProId (String proId) throws SQLException;
	public TbProductAttr queryAttrById(String attrId) throws SQLException;
		public List queryAllProType() throws SQLException;



		public List queryProductByCondition(Map paramMap) throws SQLException;



	public String addProAttr(TbProductAttr attr) throws SQLException;
	public boolean editProAttr(TbProductAttr attr) throws SQLException;
	public boolean delProAttr(String proAttrId) throws SQLException;


}



package com.hxh.dao.TbOrderProRel.impl;


import com.hxh.dao.Base.impl.BaseDaoImpl;
import com.hxh.dao.TbOrderProRel.TbOrderProRelDao;
import com.hxh.model.TbOrderProRel;

import java.sql.SQLException;
import java.util.List;


public class TbOrderProRelDaoImpl extends BaseDaoImpl<TbOrderProRel> implements TbOrderProRelDao {

	private static final String OP_QUERYPRODUCTLISTBYORDERID = ".queryProductListByOrderId";

	public String save(TbOrderProRel model) throws SQLException {


		String statementName = getNamespace(this) + OP_INSERT;
	    String id = super.save(statementName,model);
		if(null != id ){
			return id.toString();
		}
		return  null;
	}


	public boolean  update(TbOrderProRel model) throws SQLException {

		String statementName = getNamespace(this) + OP_UPDATE;
		boolean result = false;
		result = super.update(statementName,model);
		return result;

	}


	public String deleteById(String id) throws SQLException {


		String statementName = getNamespace(this) + OP_DELETE;

		return super.deleteById(statementName,id);

	}


	public TbOrderProRel queryById(String id) throws SQLException {

		String statementName = getNamespace(this) + OP_GETBYID;

		return super.queryById(statementName, id);
	}


	public List listAll() throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYALL;

		return super.listAll(statementName);
	}

	public List queryProductListByOrderId(String orderId) throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYPRODUCTLISTBYORDERID;
		return getSqlMapClient().queryForList(statementName,orderId);
	}
}

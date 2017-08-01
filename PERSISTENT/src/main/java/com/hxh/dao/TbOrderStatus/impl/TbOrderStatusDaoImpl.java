
package com.hxh.dao.TbOrderStatus.impl;
import com.hxh.dao.Base.impl.BaseDaoImpl;
import com.hxh.dao.TbOrderStatus.TbOrderStatusDao;
import com.hxh.model.TbOrderStatus;

import java.sql.SQLException;
import java.util.List;

public class TbOrderStatusDaoImpl extends BaseDaoImpl<TbOrderStatus> implements TbOrderStatusDao {

	private static final String OP_QUERYSTATUSLISTBYORDERID = ".queryStatusListByOrderId";

	public String save(TbOrderStatus model) throws SQLException {


		String statementName = getNamespace(this) + OP_INSERT;
	    String id = super.save(statementName,model);
		if(null != id ){
			return id.toString();
		}
		return  null;
	}


	public boolean  update(TbOrderStatus model) throws SQLException {

		String statementName = getNamespace(this) + OP_UPDATE;
		boolean result = false;
		result = super.update(statementName,model);
		return result;

	}


	public String deleteById(String id) throws SQLException {


		String statementName = getNamespace(this) + OP_DELETE;

		return super.deleteById(statementName,id);

	}


	public TbOrderStatus queryById(String id) throws SQLException {

		String statementName = getNamespace(this) + OP_GETBYID;

		return super.queryById(statementName, id);
	}


	public List listAll() throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYALL;

		return super.listAll(statementName);
	}

	public List queryStatusListByOrderId(String orderId) throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYSTATUSLISTBYORDERID;
		return getSqlMapClient().queryForList(statementName,orderId);
	}
}

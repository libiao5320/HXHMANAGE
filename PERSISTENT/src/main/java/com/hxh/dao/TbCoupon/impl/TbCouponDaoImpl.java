

package com.hxh.dao.TbCoupon.impl;

import com.hxh.dao.Base.impl.BaseDaoImpl;
import com.hxh.dao.TbCoupon.TbCouponDao;
import com.hxh.model.TbCoupon;

import java.sql.SQLException;
import java.util.List;


public class TbCouponDaoImpl extends BaseDaoImpl<TbCoupon> implements TbCouponDao {
	public String save(TbCoupon model) throws SQLException {


		String statementName = getNamespace(this) + OP_INSERT;
	    String id = super.save(statementName,model);
		if(null != id ){
			return id.toString();
		}
		return  null;
	}


	public boolean  update(TbCoupon model) throws SQLException {

		String statementName = getNamespace(this) + OP_UPDATE;
		boolean result = false;
		result = super.update(statementName,model);
		return result;

	}


	public String deleteById(String id) throws SQLException {


		String statementName = getNamespace(this) + OP_DELETE;

		return super.deleteById(statementName,id);

	}


	public TbCoupon queryById(String id) throws SQLException {

		String statementName = getNamespace(this) + OP_GETBYID;

		return super.queryById(statementName, id);
	}


	public List listAll() throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYALL;

		return super.listAll(statementName);
	}



}

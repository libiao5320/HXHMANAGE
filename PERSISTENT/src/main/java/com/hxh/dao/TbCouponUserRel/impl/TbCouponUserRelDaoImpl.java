

package com.hxh.dao.TbCouponUserRel.impl;

import com.hxh.dao.Base.impl.BaseDaoImpl;
import com.hxh.dao.TbCouponUserRel.TbCouponUserRelDao;
import com.hxh.model.TbCouponUserRel;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.List;

public class TbCouponUserRelDaoImpl extends BaseDaoImpl<TbCouponUserRel> implements TbCouponUserRelDao {
	protected final String OP_GETBYUSERID = ".getByUserId";//根据model对象t中包含的主键提取全部数据至t中
	public String save(TbCouponUserRel model) throws SQLException {


		String statementName = getNamespace(this) + OP_INSERT;
	    String id = super.save(statementName,model);
		if(null != id ){
			return id.toString();
		}
		return  null;
	}


	public boolean  update(TbCouponUserRel model) throws SQLException {

		String statementName = getNamespace(this) + OP_UPDATE;
		boolean result = false;
		result = super.update(statementName,model);
		return result;

	}


	public String deleteById(String id) throws SQLException {


		String statementName = getNamespace(this) + OP_DELETE;

		return super.deleteById(statementName, id);

	}


	public TbCouponUserRel queryById(String id) throws SQLException {

		String statementName = getNamespace(this) + OP_GETBYID;

		return super.queryById(statementName, id);
	}

	public List<TbCouponUserRel> queryCouponListByUserId(Integer userId) throws SQLException{

		String statementName = getNamespace(this) + OP_GETBYUSERID;

		return (List<TbCouponUserRel>)getSqlMapClient().queryForList(statementName, userId);
	}


	public List listAll() throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYALL;

		return super.listAll(statementName);
	}
	
}

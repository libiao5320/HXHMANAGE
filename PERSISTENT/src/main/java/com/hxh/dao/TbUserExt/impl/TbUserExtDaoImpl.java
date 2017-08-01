
package com.hxh.dao.TbUserExt.impl;

import com.hxh.dao.Base.impl.BaseDaoImpl;
import com.hxh.dao.TbUserExt.TbUserExtDao;
import com.hxh.model.TbUserExt;

import java.sql.SQLException;
import java.util.List;

public class TbUserExtDaoImpl extends BaseDaoImpl<TbUserExt> implements TbUserExtDao {

	protected final String OP_GETBYUSERID = ".getByuseId";//根据model对象t中包含的主键提取全部数据至t中
	protected final String OP_GETMAXNO = ".getMaxNo";//根据model对象t中的数据查询满足对应条件的所有数据列表 ,可增加排序条件

	public String save(TbUserExt model) throws SQLException {

		String statementName = getNamespace(this) + OP_INSERT;
	    String id = super.save(statementName,model);
		if(null != id ){
			return id.toString();
		}
		return  null;
	}


	public boolean  update(TbUserExt model) throws SQLException {

		String statementName = getNamespace(this) + OP_UPDATE;
		boolean result = false;
		result = super.update(statementName,model);
		return result;

	}


	public String deleteById(String id) throws SQLException {


		String statementName = getNamespace(this) + OP_DELETE;

		return super.deleteById(statementName,id);

	}


	public TbUserExt queryById(String id) throws SQLException {

		String statementName = getNamespace(this) + OP_GETBYID;

		return super.queryById(statementName, id);
	}

	public String getMaxNo() throws SQLException {

		String statementName = getNamespace(this) + OP_GETMAXNO;

		String aa =  (String)getSqlMapClient().queryForObject(statementName);
		return aa;
	}


	public List listAll() throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYALL;

		return super.listAll(statementName);
	}

}

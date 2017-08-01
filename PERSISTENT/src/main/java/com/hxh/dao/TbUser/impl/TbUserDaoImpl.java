
package com.hxh.dao.TbUser.impl;


import com.hxh.dao.Base.impl.BaseDaoImpl;
import com.hxh.dao.TbUser.TbUserDao;
import com.hxh.model.TbUser;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TbUserDaoImpl extends BaseDaoImpl<TbUser> implements TbUserDao {

	private final String OP_LISTUSER = ".listUser";//查询同级地域

	public String save(TbUser model) throws SQLException {


		String statementName = getNamespace(this) + OP_INSERT;
	    String id = super.save(statementName,model);
		if(null != id ){
			return id.toString();
		}
		return  null;
	}


	public boolean  update(TbUser model) throws SQLException {

		String statementName = getNamespace(this) + OP_UPDATE;
		boolean result = false;
		result = super.update(statementName,model);
		return result;

	}


	public String deleteById(String id) throws SQLException {


		String statementName = getNamespace(this) + OP_DELETE;

		return super.deleteById(statementName,id);

	}


	public TbUser queryById(String id) throws SQLException {

		String statementName = getNamespace(this) + OP_GETBYID;

		return super.queryById(statementName, id);
	}


	public List listAll() throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYALL;

		return super.listAll(statementName);
	}

	public List listUser(Map<String,Object> paramMap) throws SQLException {
		String statementName = getNamespace(this) + OP_LISTUSER;

		return getSqlMapClient().queryForList(statementName,paramMap);
	}

}

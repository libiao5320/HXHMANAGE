

package com.hxh.dao.TbUserAccount.impl;


import com.hxh.dao.Base.impl.BaseDaoImpl;
import com.hxh.dao.TbUserAccount.TbUserAccountDao;
import com.hxh.model.TbUserAccount;

import java.sql.SQLException;
import java.util.List;

public class TbUserAccountDaoImpl extends BaseDaoImpl<TbUserAccount> implements TbUserAccountDao {
	private final String OP_QUERTBYUSERID = ".queryByUserId";


	public String save(TbUserAccount model) throws SQLException {


		String statementName = getNamespace(this) + OP_INSERT;
	    String id = super.save(statementName,model);
		if(null != id ){
			return id.toString();
		}
		return  null;
	}


	public boolean  update(TbUserAccount model) throws SQLException {

		String statementName = getNamespace(this) + OP_UPDATE;
		boolean result = false;
		result = super.update(statementName,model);
		return result;

	}


	public String deleteById(String id) throws SQLException {


		String statementName = getNamespace(this) + OP_DELETE;

		return super.deleteById(statementName,id);

	}


	public TbUserAccount queryById(String id) throws SQLException {

		String statementName = getNamespace(this) + OP_GETBYID;

		return super.queryById(statementName, id);
	}


	public List listAll() throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYALL;

		return super.listAll(statementName);
	}

	public TbUserAccount queryByUserId(Integer userId) throws SQLException {
		String statementName = getNamespace(this) + OP_QUERTBYUSERID;
		return (TbUserAccount) getSqlMapClient().queryForObject(statementName,userId);
	}
}

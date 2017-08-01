

package com.hxh.dao.TbDiser.impl;


import com.hxh.dao.Base.impl.BaseDaoImpl;
import com.hxh.dao.TbDiser.TbDiserDao;
import com.hxh.model.TbCommunity;
import com.hxh.model.TbDiser;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TbDiserDaoImpl extends BaseDaoImpl<TbDiser> implements TbDiserDao {

	private final String OP_GOODDISER = ".goodDiser";//赞
	private final String OP_BADDISER = ".badDiser";//踩
	private final String OP_MANAGELISTDISER = ".manageListDiserByCondition";//踩

	public String save(TbDiser model) throws SQLException {


		String statementName = getNamespace(this) + OP_INSERT;
	    String id = super.save(statementName,model);
		if(null != id ){
			return id.toString();
		}
		return  null;
	}


	public boolean  update(TbDiser model) throws SQLException {

		String statementName = getNamespace(this) + OP_UPDATE;
		boolean result = false;
		result = super.update(statementName,model);
		return result;

	}


	public String deleteById(String id) throws SQLException {


		String statementName = getNamespace(this) + OP_DELETE;

		return super.deleteById(statementName, id);

	}


	public TbDiser queryById(String id) throws SQLException {

		String statementName = getNamespace(this) + OP_GETBYID;

		return super.queryById(statementName, id);
	}


	public List manageListDiser(Map params) throws SQLException {
		String statementName = getNamespace(this) + OP_MANAGELISTDISER;
		return getSqlMapClient().queryForList(statementName, params);
	}


	public List listAll() throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYALL;

		return super.listAll(statementName);
	}

	public boolean goodDiser(String disId) throws SQLException {
		String statementName = getNamespace(this) + OP_GOODDISER;

		if (getSqlMapClient().update(statementName,disId) > 0) {
			return true;
		}
		return false;
	}

	public boolean badDiser(String disId) throws SQLException {
		String statementName = getNamespace(this) + OP_BADDISER;

		if (getSqlMapClient().update(statementName,disId) > 0) {
			return true;
		}
		return false;
	}
}

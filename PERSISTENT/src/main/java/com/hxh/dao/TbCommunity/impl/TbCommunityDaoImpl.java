

package com.hxh.dao.TbCommunity.impl;


import com.hxh.dao.Base.impl.BaseDaoImpl;
import com.hxh.dao.TbCommunity.TbCommunityDao;
import com.hxh.model.TbCommunity;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TbCommunityDaoImpl extends BaseDaoImpl<TbCommunity> implements TbCommunityDao {

	private final String OP_QUERYREGCOMM = ".queryRegComm";//查询社区详地址
	private final String OP_QUERYNEARCOMM = ".queryNearComm";//查询社区详地址

	private final String OP_QUERYFULLCOMM = ".queryFullComm";//查询社区详地址，并显示省市区
	private final String OP_GETCOMMUNITYBYID = ".getCommunityById";//查询社区详地址，并显示省市区

	public String save(TbCommunity model) throws SQLException {


		String statementName = getNamespace(this) + OP_INSERT;
	    String id = super.save(statementName,model);
		if(null != id ){
			return id.toString();
		}
		return  null;
	}


	public boolean  update(TbCommunity model) throws SQLException {

		String statementName = getNamespace(this) + OP_UPDATE;
		boolean result = false;
		result = super.update(statementName,model);
		return result;

	}


	public String deleteById(String id) throws SQLException {


		String statementName = getNamespace(this) + OP_DELETE;

		return super.deleteById(statementName,id);

	}


	public TbCommunity queryById(String id) throws SQLException {

		String statementName = getNamespace(this) + OP_GETBYID;

		return super.queryById(statementName, id);
	}


	public List listAll() throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYALL;

		return super.listAll(statementName);
	}

	public List listRegComm(TbCommunity model) throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYREGCOMM;
		return (List)getSqlMapClient().queryForList(statementName,model);
	}

	public List queryFullComm(Map searchValue) throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYFULLCOMM;
		return (List)getSqlMapClient().queryForList(statementName,searchValue);
	}

	public List queryNearComm(HashMap map) throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYNEARCOMM;
		List ls =  (List)getSqlMapClient().queryForList(statementName,map);
		return ls;
	}

	public Map<String,String> getCommunityById(String commId) throws SQLException{
		String statementName = getNamespace(this) + OP_GETCOMMUNITYBYID;
		return (Map<String,String>)getSqlMapClient().queryForObject(statementName,commId);
	}
}

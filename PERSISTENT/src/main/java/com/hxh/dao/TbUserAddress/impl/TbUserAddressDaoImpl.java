
package com.hxh.dao.TbUserAddress.impl;

import com.hxh.dao.Base.impl.BaseDaoImpl;
import com.hxh.dao.TbUserAddress.TbUserAddressDao;
import com.hxh.model.TbUserAddress;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TbUserAddressDaoImpl extends BaseDaoImpl<TbUserAddress> implements TbUserAddressDao {

	private final String OP_QUERYUSERADDRLIST = ".queryUserAddrList";//查询用户地址
	private final String OP_QUERYUSERADDLISTBYUSERID =".queryUserAddListByUserId";//根据用户ID查询所有地址
	private final String OP_QUERYDEFAULTUSERADDBYUSERID =".getDefaultUserAddByUserId";//根据用户ID查询默认地址
	private final String OP_QUERYFULLADDRESSBYID =".getFullAddressById";//根据用户ID查询默认地址
	private final String OP_UPDATEALLUSERADDSTATE = ".updateAllUserAddState";//修改用户地址状态列表
	private final String OP_UPDATEUSERADDSTATE = ".updateUserAddState";//修改用户地址状态
	private final String OP_GETNEWUSERADDRESSID = ".getNewUserAddressId";//获得用户最新添加地址ID

	public String save(TbUserAddress model) throws SQLException {


		String statementName = getNamespace(this) + OP_INSERT;
	    String id = super.save(statementName,model);
		if(null != id ){
			return id.toString();
		}
		return  null;
	}


	public boolean  update(TbUserAddress model) throws SQLException {

		String statementName = getNamespace(this) + OP_UPDATE;
		boolean result = false;
		result = super.update(statementName,model);
		return result;

	}


	public String deleteById(String id) throws SQLException {


		String statementName = getNamespace(this) + OP_DELETE;

		return super.deleteById(statementName,id);

	}


	public TbUserAddress queryById(String id) throws SQLException {

		String statementName = getNamespace(this) + OP_GETBYID;

		return super.queryById(statementName, id);
	}


	public List listAll() throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYALL;

		return super.listAll(statementName);
	}

	public List listUserAddr(TbUserAddress model) throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYUSERADDRLIST;

		return getSqlMapClient().queryForList(statementName, model);
	}


	public List listUserAddByUserId(Integer userId) throws SQLException
	{

		String statementName = getNamespace(this) + OP_QUERYUSERADDLISTBYUSERID;

		return getSqlMapClient().queryForList(statementName, ""+userId);

	}

	public Map getDefaultUserAddByUserId(Integer userId) throws SQLException {
		Map userAddress = null;
		String statementName = getNamespace(this) + OP_QUERYDEFAULTUSERADDBYUSERID;
		Object o =  getSqlMapClient().queryForObject(statementName, "" + userId);
		if(null != o )
			userAddress = (Map) o;

		return userAddress;
	}

	public Map getFullAddressById(Integer addressId) throws SQLException {
		Map userAddress = null;
		String statementName = getNamespace(this) + OP_QUERYFULLADDRESSBYID;
		Object o =  getSqlMapClient().queryForObject(statementName,  addressId);
		if(null != o )
			userAddress = (Map) o;

		return userAddress;
	}

	public Integer updateAllUserAddState(TbUserAddress model) throws SQLException {
		Map userAddress = null;
		Integer count  = 0;
		String statementName = getNamespace(this) + OP_UPDATEALLUSERADDSTATE;
		Object o =  getSqlMapClient().update(statementName, model);
		if(null != o )
			count = (Integer) o;

		return count;
	}

	public Integer updateUserAddState(TbUserAddress model) throws SQLException {
		String statementName = getNamespace(this) + OP_UPDATEUSERADDSTATE;
		Integer count  = 0;
		Object o =  getSqlMapClient().update(statementName, model);
		if(null != o )
			count = (Integer) o;

		return count;
	}

	public String getNewUserAddressId(TbUserAddress model) throws SQLException {
		String statementName = getNamespace(this) + OP_GETNEWUSERADDRESSID;
		return (String)getSqlMapClient().queryForObject(statementName,model);
	}

}

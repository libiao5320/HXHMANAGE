
package com.hxh.dao.TbCommDetail.impl;

import com.hxh.dao.Base.impl.BaseDaoImpl;
import com.hxh.dao.TbCommDetail.TbCommDetailDao;
import com.hxh.model.TbCommDetail;

import java.sql.SQLException;
import java.util.List;

public class TbCommDetailDaoImpl extends BaseDaoImpl<TbCommDetail> implements TbCommDetailDao {

	private final String OP_QUERYCOMMDETAIL = ".queryCommDetail";//查询社区详细地址
	private final String OP_QUERYCOMMDETAILBYCOMMID = ".queryCommDetailByCommId";//查询社区详细地址
	private final String OP_GETIDS = ".getIds";//查询社区详细地址ID列表
	private final String OP_DELETEBYCOMMID = ".deleteByCommId";//根据小区ID删除小区明细

	public String save(TbCommDetail model) throws SQLException {


		String statementName = getNamespace(this) + OP_INSERT;
	    String id = super.save(statementName,model);
		if(null != id ){
			return id.toString();
		}
		return  null;
	}


	public boolean  update(TbCommDetail model) throws SQLException {

		String statementName = getNamespace(this) + OP_UPDATE;
		boolean result = false;
		result = super.update(statementName,model);
		return result;

	}


	public String deleteById(String id) throws SQLException {


		String statementName = getNamespace(this) + OP_DELETE;

		return super.deleteById(statementName,id);

	}


	public TbCommDetail queryById(String id) throws SQLException {

		String statementName = getNamespace(this) + OP_GETBYID;

		return super.queryById(statementName, id);
	}

	public List listAll() throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYALL;

		return super.listAll(statementName);
	}

	public List listCommDetail(TbCommDetail model) throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYCOMMDETAIL;

		return getSqlMapClient().queryForList(statementName, model);
	}

	public List queryCommDetailByCommId(Integer commId) throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYCOMMDETAILBYCOMMID;

		return getSqlMapClient().queryForList(statementName,commId);
	}

	public List<String> getIds() throws SQLException {
		String statementName = getNamespace(this) + OP_GETIDS;

		return getSqlMapClient().queryForList(statementName);
	}

	public int deleteByCommId(String commId) throws SQLException {

		String statementName = getNamespace(this) + OP_DELETEBYCOMMID;

		return getSqlMapClient().delete(statementName, commId);
	}
}

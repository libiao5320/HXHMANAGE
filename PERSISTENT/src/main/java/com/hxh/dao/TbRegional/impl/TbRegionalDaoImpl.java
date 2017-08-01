

package com.hxh.dao.TbRegional.impl;
import com.hxh.dao.Base.impl.BaseDaoImpl;
import com.hxh.dao.TbRegional.TbRegionalDao;
import com.hxh.model.TbRegional;

import java.sql.SQLException;
import java.util.List;
public class TbRegionalDaoImpl extends BaseDaoImpl<TbRegional> implements TbRegionalDao {

	private final String OP_QUERYCHILDREN = ".queryChildren";//查询地域子集
	private final String OP_QUERYRELATE = ".queryRelate";//查询同级地域

	public String save(TbRegional model) throws SQLException {


		String statementName = getNamespace(this) + OP_INSERT;
	    String id = super.save(statementName,model);
		if(null != id ){
			return id.toString();
		}
		return  null;
	}


	public boolean  update(TbRegional model) throws SQLException {

		String statementName = getNamespace(this) + OP_UPDATE;
		boolean result = false;
		result = super.update(statementName,model);
		return result;

	}


	public String deleteById(String id) throws SQLException {


		String statementName = getNamespace(this) + OP_DELETE;

		return super.deleteById(statementName, id);

	}


	public TbRegional queryById(String id) throws SQLException {

		String statementName = getNamespace(this) + OP_GETBYID;

		return super.queryById(statementName, id);
	}


	public List listAll() throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYALL;

		return super.listAll(statementName);
	}

	public List listRegional(String parentId) throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYCHILDREN;

		return (List)getSqlMapClient().queryForList(statementName,parentId);
	}

	public List listRelateRegional(String regId) throws SQLException{
		String statementName = getNamespace(this) + OP_QUERYRELATE;

		return (List)getSqlMapClient().queryForList(statementName,regId);
	}

}

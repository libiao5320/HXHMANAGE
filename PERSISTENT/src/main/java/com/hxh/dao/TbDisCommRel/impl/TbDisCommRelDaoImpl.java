

package com.hxh.dao.TbDisCommRel.impl;

import com.hxh.dao.Base.impl.BaseDaoImpl;
import com.hxh.dao.TbDisCommRel.TbDisCommRelDao;
import com.hxh.model.TbDisCommRel;

import java.sql.SQLException;
import java.util.List;


public class TbDisCommRelDaoImpl extends BaseDaoImpl<TbDisCommRel> implements TbDisCommRelDao {

	private final String OP_GETBYCOMMID = ".getByCommId";//通过小区ID查询快递员ID
	private final String OP_GETBYDISID = ".getByDisId";//通过小区ID查询快递员ID
	private final String OP_DELETEBYDISID = ".deleteByDisId";//通过小区ID查询快递员ID
	private final String OP_DELCOMMREL = ".delCommRel";//通过小区ID查询快递员ID
	private final String OP_QUERYBYCOMMIDDISERID = ".queryByCommidDiserid";//通过小区ID查询快递员ID
	private final String OP_SAVE = ".save";//保存小区关联配送员
	private final String OP_DELETEBYCOMMID = ".deleteByCommId";//删除小区关联的配送人员

	public String save(TbDisCommRel model) throws SQLException {


		String statementName = getNamespace(this) + OP_INSERT;
	    String id = super.save(statementName,model);
		if(null != id ){
			return id.toString();
		}
		return  null;
	}

	public String save(List<TbDisCommRel> disCommRels) throws SQLException {

		String statementName = getNamespace(this) + OP_SAVE;

		return (String)getSqlMapClient().insert(statementName,disCommRels);
	}

	public boolean  update(TbDisCommRel model) throws SQLException {

		String statementName = getNamespace(this) + OP_UPDATE;
		boolean result = false;
		result = super.update(statementName,model);
		return result;

	}


	public String deleteById(String id) throws SQLException {


		String statementName = getNamespace(this) + OP_DELETE;

		return super.deleteById(statementName,id);

	}
	public String deleteByDisId(String disId) throws SQLException {


		String statementName = getNamespace(this) + OP_DELETEBYDISID;

		return super.deleteById(statementName, disId);

	}
	public String delCommRel(TbDisCommRel tbDisCommRel) throws SQLException {

		String statementName = getNamespace(this) + OP_DELCOMMREL;

		return String.valueOf(getSqlMapClient().delete(statementName, tbDisCommRel));

	}


	public TbDisCommRel queryById(String id) throws SQLException {

		String statementName = getNamespace(this) + OP_GETBYID;

		return super.queryById(statementName, id);
	}

	public TbDisCommRel queryByCommIdDiserId(TbDisCommRel tbDisCommRel) throws SQLException {

		String statementName = getNamespace(this) + OP_QUERYBYCOMMIDDISERID;
		return (TbDisCommRel)getSqlMapClient().queryForObject(statementName, tbDisCommRel);
	//	return super.queryById(statementName, tbDisCommRel);
	}

	public TbDisCommRel queryByCommIdDiserId(String id) throws SQLException {

		String statementName = getNamespace(this) + OP_GETBYID;

		return super.queryById(statementName, id);
	}


	public List listAll() throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYALL;

		return super.listAll(statementName);
	}

	public TbDisCommRel getByCommId(String commId) throws SQLException {

		String statementName = getNamespace(this) + OP_GETBYCOMMID;

		return super.queryById(statementName, commId);
	}

	public List getByDisId(String disId) throws SQLException {

		String statementName = getNamespace(this) + OP_GETBYDISID;

		return (List)getSqlMapClient().queryForList(statementName, disId);
	}

	public String deleteByCommId(String disId) throws SQLException {


		String statementName = getNamespace(this) + OP_DELETEBYCOMMID;

		return super.deleteById(statementName,disId);

	}

}

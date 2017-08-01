

package com.hxh.dao.TbProduct.impl;

import com.hxh.dao.Base.impl.BaseDaoImpl;
import com.hxh.dao.TbProduct.TbProductDao;
import com.hxh.model.TbProduct;
import com.hxh.model.TbProductAttr;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TbProductDaoImpl extends BaseDaoImpl<TbProduct> implements TbProductDao {
	private final String OP_GETPRICELIST = ".getPriceList";
	private final String OP_MANAGEPROLIST = ".manageProList";
	private final String OP_MANAGEPROTYPELIST = ".manageProTypeList";
	private final String OP_QUERYPROATTRBYPROID = ".queryProAttrByProId";
	private final String OP_QUERYALLPROTYPE = ".queryAllProType";
	private final String OP_QUERYPRODUCTBYCONDITION = ".queryProductByCondition";
	private final String OP_ADDPROATTR = ".insertProAttr";
	private final String OP_EDITPROATTR = ".updateProAttr";
	private final String OP_QUERYATTRBYID = ".queryAttrById";
	private final String OP_DELETEPROATTR = ".deleteProAttr";


	public String save(TbProduct model) throws SQLException {


		String statementName = getNamespace(this) + OP_INSERT;
	    String id = super.save(statementName,model);
		if(null != id ){
			return id.toString();
		}
		return  null;
	}


	public boolean  update(TbProduct model) throws SQLException {

		String statementName = getNamespace(this) + OP_UPDATE;
		boolean result = false;
		result = super.update(statementName,model);
		return result;

	}


	public String deleteById(String id) throws SQLException {


		String statementName = getNamespace(this) + OP_DELETE;

		return super.deleteById(statementName,id);

	}


	public TbProduct queryById(String id) throws SQLException {

		String statementName = getNamespace(this) + OP_GETBYID;

		return super.queryById(statementName, id);
	}


	public List listAll() throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYALL;

		return super.listAll(statementName);
	}

	public List getPriceList() throws SQLException {

		String statementName = getNamespace(this) + OP_GETPRICELIST;

		return getSqlMapClient().queryForList(statementName);


	}

	public List mangeProList() throws SQLException {




		String statementName = getNamespace(this) + OP_MANAGEPROLIST;

		return getSqlMapClient().queryForList(statementName);

	}

	public List mangeProTypeList() throws SQLException {

		String statementName = getNamespace(this) + OP_MANAGEPROTYPELIST;

		return getSqlMapClient().queryForList(statementName);

	}

	public List queryAttrByProId(String proId) throws SQLException {


		String statementName = getNamespace(this) + OP_QUERYPROATTRBYPROID;

		return getSqlMapClient().queryForList(statementName,proId);

	}

	public TbProductAttr queryAttrById(String attrId) throws SQLException {

		String statementName = getNamespace(this) + OP_QUERYATTRBYID;
		return (TbProductAttr) getSqlMapClient().queryForObject(statementName,attrId);
	}

	public List queryAllProType() throws SQLException {


		String statementName = getNamespace(this) + OP_QUERYALLPROTYPE;

		return getSqlMapClient().queryForList(statementName);

	}

	public List queryProductByCondition(Map paramMap) throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYPRODUCTBYCONDITION;

		return getSqlMapClient().queryForList(statementName,paramMap);
	}

	public String addProAttr(TbProductAttr attr) throws SQLException {

		String statementName = getNamespace(this) + OP_ADDPROATTR;
		Object id = getSqlMapClient().insert(statementName, attr);
		if(null != id ){
			return "" + id;
		}
		return null;
	}

	public boolean editProAttr(TbProductAttr attr) throws SQLException {

		String statementName = getNamespace(this) + OP_EDITPROATTR;

		return  getSqlMapClient().update(statementName,attr) > 0 ?true:false;
	}


	public boolean delProAttr(String attrId)throws SQLException
	{
		String statementName = getNamespace(this) + OP_DELETEPROATTR;

		return  getSqlMapClient().delete(statementName, attrId) > 0 ?true:false;


	}
}

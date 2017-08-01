

package com.hxh.dao.TbOrder.impl;


import com.hxh.dao.Base.impl.BaseDaoImpl;
import com.hxh.dao.TbOrder.TbOrderDao;
import com.hxh.model.TbOrder;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TbOrderDaoImpl extends BaseDaoImpl<TbOrder> implements TbOrderDao {

	private final String OP_QUERYORDERLIST = ".queryOrderList";//��ѯ�����б�
	private final String OP_GETBYSEQ = ".getBySeq";//���ݶ�����Ų�ѯ������Ϣ�Ƿ����
	private final String OP_QUERYBYUSERID = ".queryOrderByUserId";//���ݶ�����Ų�ѯ������Ϣ�Ƿ����
	private final String OP_MANAGELISTORDERS = ".manageListOrders";//���ݶ�����Ų�ѯ������Ϣ�Ƿ����
	private final String OP_MANAGELISTORDERSBYCONDITION = ".manageListOrdersByCondition";//���ݶ�����Ų�ѯ������Ϣ�Ƿ����
	private final String OP_DELORDER = ".delOrder";//���ݶ�����Ų�ѯ������Ϣ�Ƿ����
	private final String OP_QUEERYORDERDETAIL = ".queryOrderDetail";


	public String save(TbOrder model) throws SQLException {


		String statementName = getNamespace(this) + OP_INSERT;
	    String id = super.save(statementName,model);
		if(null != id ){
			return id.toString();
		}
		return  null;
	}


	public boolean  update(TbOrder model) throws SQLException {

		String statementName = getNamespace(this) + OP_UPDATE;
		boolean result = false;
		result = super.update(statementName,model);
		return result;

	}


	public String deleteById(String id) throws SQLException {


		String statementName = getNamespace(this) + OP_DELETE;

		return super.deleteById(statementName,id);

	}


	public TbOrder queryById(String id) throws SQLException {

		String statementName = getNamespace(this) + OP_GETBYID;

		return super.queryById(statementName, id);
	}


	public List listAll() throws SQLException {
		String statementName = getNamespace(this) + OP_QUERYALL;

		return super.listAll(statementName);
	}

	public List queryOrderList(TbOrder order) throws SQLException {

		String statementName = getNamespace(this) + OP_QUERYORDERLIST;

		return getSqlMapClient().queryForList(statementName,order);
	}

	public boolean getBySeq(String seq) throws SQLException {

		String statementName = getNamespace(this) + OP_GETBYSEQ;

		Integer sign = (Integer)getSqlMapClient().queryForObject(statementName,seq);
		if (sign != null) {
			return true;
		} else {
			return false;
		}

	}

	public List queryOrderByUserId(Integer userId) throws SQLException {


		String statementName = getNamespace(this) + OP_QUERYBYUSERID;

		return getSqlMapClient().queryForList(statementName,userId);
	}

	public List manageListOrder(String type) throws SQLException {

		String statementName = getNamespace(this) + OP_MANAGELISTORDERS;

		return getSqlMapClient().queryForList(statementName,type);

	}

	public List manageListOrder(Map params) throws SQLException {
		String statementName = getNamespace(this) + OP_MANAGELISTORDERSBYCONDITION;

		return getSqlMapClient().queryForList(statementName,params);
	}

	public boolean delOrder(String orderId) throws SQLException {
		String statementName =getNamespace(this) + OP_DELORDER;
		int result = 0;
		boolean flag = false;

		result =  getSqlMapClient().update(statementName, orderId);
		if(result >0)
			flag = true;
		return flag;
	}

	public Map queryOrderDetail(String orderId) throws SQLException {
		String statementName = getNamespace(this) + OP_QUEERYORDERDETAIL;
		Map result  = (Map) getSqlMapClient().queryForObject(statementName, orderId);
		return result;
	}
}

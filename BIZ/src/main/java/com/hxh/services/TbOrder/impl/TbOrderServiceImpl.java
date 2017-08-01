

package com.hxh.services.TbOrder.impl;

import com.hxh.dao.TbOrder.TbOrderDao;
import com.hxh.dao.TbOrderProRel.TbOrderProRelDao;
import com.hxh.dao.TbOrderStatus.TbOrderStatusDao;
import com.hxh.model.TbOrder;
import com.hxh.model.TbOrderBaseInfo;
import com.hxh.model.TbOrderStatus;
import com.hxh.services.base.impl.BaseServiceImpl;
import com.hxh.services.TbOrder.TbOrderService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TbOrderServiceImpl extends BaseServiceImpl<TbOrder> implements TbOrderService {

	private TbOrderDao tbOrderDao = null;
	private TbOrderProRelDao tbOrderProRelDao = null;
	private TbOrderStatusDao tbOrderStatusDao = null;


	public void setTbOrderStatusDao(TbOrderStatusDao tbOrderStatusDao) {
		this.tbOrderStatusDao = tbOrderStatusDao;
	}

	public void setTbOrderProRelDao(TbOrderProRelDao tbOrderProRelDao) {
		this.tbOrderProRelDao = tbOrderProRelDao;
	}

	public void setTbOrderDao(TbOrderDao tbOrderDao) {
		this.tbOrderDao = tbOrderDao;
	}



//	public String save(TbOrder order,TbOrderBaseInfo orderlInfo,TbOrderStatus orderStatus) throws Exception {
//
//		// 设置订单编号
//		order.setOrderSeq(makeOrderSEQ());
//		// 保存订单
//		String id = tbOrderDao.save(order);
//		// 保存订单详细信息
//		Integer orderId = Integer.valueOf(id);
//		orderlInfo.setOrderId(orderId);
//		tbOrderBaseInfoDao.save(orderlInfo);
//		// 保存状态
//		if (orderStatus == null) {
//			orderStatus = new TbOrderStatus();
//		}
//		orderStatus.setOrderId(orderId);
//		orderStatus.setStatusId(order.getOrderStatus());
//
//		tbOrderStatusDao.save(orderStatus);
//
//		return id;
//	}


	public boolean update(TbOrder model) throws Exception {

		return tbOrderDao.update(model);
	}

//	public void updateStatus(TbOrder order,TbOrderStatus orderStatus) throws Exception {
//		tbOrderDao.update(order);
//		orderStatus.setOrderId(order.getOrderId());
//		orderStatus.setStatusId(order.getOrderStatus());
//		tbOrderStatusDao.update(orderStatus);
//	}

	public String save(TbOrder order, TbOrderBaseInfo orderlInfo, TbOrderStatus orderStatus) throws Exception {
		return null;
	}

	public void updateStatus(TbOrder order, TbOrderStatus orderStatus) throws Exception {

	}

	public List queryOrderList(TbOrder order) throws Exception {
		return tbOrderDao.queryOrderList(order);
	}

	public List queryOrderListByUserId(Integer userId) throws Exception {
		return tbOrderDao.queryOrderByUserId(userId);
	}

	public List manageListOrder(String type) throws Exception {




		return tbOrderDao.manageListOrder(type);
	}

	public List manageListOrder(Map params) throws Exception {

		return tbOrderDao.manageListOrder(params);
	}


	public boolean delOrder(String orderId) throws Exception{


		return tbOrderDao.delOrder(orderId);
	}

	public Map queryOrderDetail(String orderId) throws Exception {
		return tbOrderDao.queryOrderDetail(orderId);
	}

	public boolean checkOrder(List proList,TbOrder order,String chkId) throws Exception {
		return false;
	}


	public String deleteById(String id) throws Exception {


		return tbOrderDao.deleteById(id);

	}


	public TbOrder queryById(String id) throws Exception {

		return tbOrderDao.queryById(id);
	}


	public List listAll() throws Exception {
		
		return tbOrderDao.listAll();
	}

	//生成订单编号 四个随即数+八位日期格式
	private String makeOrderSEQ() throws Exception {
		Random random = new Random();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String dateFormat = format.format(new Date());

		StringBuffer orderSEQ = null;

		do {
			orderSEQ = new StringBuffer("W");
			orderSEQ.append(dateFormat);
			for (int i = 0; i < 6; i++) {
				orderSEQ.append(random.nextInt(9));
			}

		} while (tbOrderDao.getBySeq(orderSEQ.toString()));

		return orderSEQ.toString();
	}

}

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.services.TbOrderStatus.impl;

import com.hxh.dao.TbOrderStatus.TbOrderStatusDao;
import com.hxh.model.TbOrderStatus;
import com.hxh.services.base.impl.BaseServiceImpl;
import com.hxh.services.TbOrderStatus.TbOrderStatusService;

import java.util.List;

public class TbOrderStatusServiceImpl extends BaseServiceImpl<TbOrderStatus> implements TbOrderStatusService {

	private TbOrderStatusDao tbOrderStatusDao = null;


	public void setTbOrderStatusDao(TbOrderStatusDao tbOrderStatusDao) {
		this.tbOrderStatusDao = tbOrderStatusDao;
	}	


	public String save(TbOrderStatus model) throws Exception {


		return tbOrderStatusDao.save(model);
	}


	public boolean  update(TbOrderStatus model) throws Exception {

		return tbOrderStatusDao.update(model);
	}


	public String deleteById(String id) throws Exception {


		return tbOrderStatusDao.deleteById(id);

	}


	public TbOrderStatus queryById(String id) throws Exception {

		return tbOrderStatusDao.queryById(id);
	}


	public List listAll() throws Exception {
			return 	tbOrderStatusDao.listAll();
	}

	public List queryStatusListByOrderId(String orderId) throws Exception {
		return tbOrderStatusDao.queryStatusListByOrderId(orderId);
	}
}

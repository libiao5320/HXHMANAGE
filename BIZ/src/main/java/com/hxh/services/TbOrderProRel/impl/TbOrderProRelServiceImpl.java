

package com.hxh.services.TbOrderProRel.impl;
import com.hxh.dao.TbOrderProRel.TbOrderProRelDao;
import com.hxh.model.TbOrderProRel;
import com.hxh.services.base.impl.BaseServiceImpl;
import com.hxh.services.TbOrderProRel.TbOrderProRelService;

import java.util.List;

public class TbOrderProRelServiceImpl extends BaseServiceImpl<TbOrderProRel> implements TbOrderProRelService {

	private TbOrderProRelDao tbOrderProRelDao = null;


	public void setTbOrderProRelDao(TbOrderProRelDao tbOrderProRelDao) {
		this.tbOrderProRelDao = tbOrderProRelDao;
	}	


	public String save(TbOrderProRel model) throws Exception {


		return tbOrderProRelDao.save(model);
	}


	public boolean  update(TbOrderProRel model) throws Exception {

		return tbOrderProRelDao.update(model);
	}


	public String deleteById(String id) throws Exception {


		return tbOrderProRelDao.deleteById(id);

	}


	public TbOrderProRel queryById(String id) throws Exception {

		return tbOrderProRelDao.queryById(id);
	}


	public List listAll() throws Exception {
			return 	tbOrderProRelDao.listAll();
	}

	public List queryProductListByOrderId(String orderId) throws Exception{
		return tbOrderProRelDao.queryProductListByOrderId(orderId);
	}
}

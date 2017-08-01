

package com.hxh.services.TbCoupon.impl;
import com.hxh.dao.TbCoupon.TbCouponDao;
import com.hxh.model.TbCoupon;
import com.hxh.services.base.impl.BaseServiceImpl;
import com.hxh.services.TbCoupon.TbCouponService;

import java.util.List;
import java.util.Map;

public class TbCouponServiceImpl extends BaseServiceImpl<TbCoupon> implements TbCouponService {

	private TbCouponDao tbCouponDao = null;


	public void setTbCouponDao(TbCouponDao tbCouponDao) {
		this.tbCouponDao = tbCouponDao;
	}	


	public String save(TbCoupon model) throws Exception {


		return tbCouponDao.save(model);
	}


	public boolean  update(TbCoupon model) throws Exception {

		return tbCouponDao.update(model);
	}


	public String deleteById(String id) throws Exception {


		return tbCouponDao.deleteById(id);

	}


	public TbCoupon queryById(String id) throws Exception {

		return tbCouponDao.queryById(id);
	}


	public List listAll() throws Exception {
			return 	tbCouponDao.listAll();
	}

}

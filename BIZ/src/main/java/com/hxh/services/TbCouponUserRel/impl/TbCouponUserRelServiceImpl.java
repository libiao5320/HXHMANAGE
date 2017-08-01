

package com.hxh.services.TbCouponUserRel.impl;

import com.hxh.dao.TbCouponUserRel.TbCouponUserRelDao;
import com.hxh.model.TbCouponUserRel;
import com.hxh.services.base.impl.BaseServiceImpl;
import com.hxh.services.TbCouponUserRel.TbCouponUserRelService;

import java.util.List;

public class TbCouponUserRelServiceImpl extends BaseServiceImpl<TbCouponUserRel> implements TbCouponUserRelService {

	private TbCouponUserRelDao tbCouponUserRelDao = null;


	public void setTbCouponUserRelDao(TbCouponUserRelDao tbCouponUserRelDao) {
		this.tbCouponUserRelDao = tbCouponUserRelDao;
	}	


	public String save(TbCouponUserRel model) throws Exception {


		return tbCouponUserRelDao.save(model);
	}


	public boolean  update(TbCouponUserRel model) throws Exception {

		return tbCouponUserRelDao.update(model);
	}


	public String deleteById(String id) throws Exception {


		return tbCouponUserRelDao.deleteById(id);

	}


	public TbCouponUserRel queryById(String id) throws Exception {

		return tbCouponUserRelDao.queryById(id);
	}


	public List listAll() throws Exception {
			return 	tbCouponUserRelDao.listAll();
	}

	public List queryCouponListByUserId(Integer userId) throws Exception{

		return tbCouponUserRelDao.queryCouponListByUserId(userId);
	}
}

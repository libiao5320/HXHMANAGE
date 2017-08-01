

package com.hxh.services.TbCommDetail.impl;

import com.hxh.dao.TbCommDetail.TbCommDetailDao;
import com.hxh.model.TbCommDetail;
import com.hxh.services.base.impl.BaseServiceImpl;
import com.hxh.services.TbCommDetail.TbCommDetailService;

import java.util.List;

public class TbCommDetailServiceImpl extends BaseServiceImpl<TbCommDetail> implements TbCommDetailService {

	private TbCommDetailDao tbCommDetailDao = null;


	public void setTbCommDetailDao(TbCommDetailDao tbCommDetailDao) {
		this.tbCommDetailDao = tbCommDetailDao;
	}	


	public String save(TbCommDetail model) throws Exception {


		return tbCommDetailDao.save(model);
	}


	public boolean  update(TbCommDetail model) throws Exception {

		return tbCommDetailDao.update(model);
	}


	public String deleteById(String id) throws Exception {


		return tbCommDetailDao.deleteById(id);

	}


	public TbCommDetail queryById(String id) throws Exception {

		return tbCommDetailDao.queryById(id);
	}


	public List listAll() throws Exception {
			return 	tbCommDetailDao.listAll();
	}

	public List listCommDetail(TbCommDetail model) throws Exception {
		return tbCommDetailDao.listCommDetail(model);
	}

	public List listCommDetail(Integer commId) throws Exception {
		return tbCommDetailDao.queryCommDetailByCommId(commId);
	}

	public List<String> getIds() throws Exception{
		return tbCommDetailDao.getIds();
	}
}

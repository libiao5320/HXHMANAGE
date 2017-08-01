

package com.hxh.services.TbProductType.impl;
import com.hxh.dao.TbProductType.TbProductTypeDao;
import com.hxh.model.TbProductType;
import com.hxh.services.base.impl.BaseServiceImpl;
import com.hxh.services.TbProductType.TbProductTypeService;

import java.util.List;

public class TbProductTypeServiceImpl extends BaseServiceImpl<TbProductType> implements TbProductTypeService {

	private TbProductTypeDao tbProductTypeDao = null;


	public void setTbProductTypeDao(TbProductTypeDao tbProductTypeDao) {
		this.tbProductTypeDao = tbProductTypeDao;
	}	


	public String save(TbProductType model) throws Exception {


		return tbProductTypeDao.save(model);
	}


	public boolean  update(TbProductType model) throws Exception {

		return tbProductTypeDao.update(model);
	}


	public String deleteById(String id) throws Exception {


		return tbProductTypeDao.deleteById(id);

	}


	public TbProductType queryById(String id) throws Exception {

		return tbProductTypeDao.queryById(id);
	}


	public List listAll() throws Exception {
			return 	tbProductTypeDao.listAll();
	}
	
}

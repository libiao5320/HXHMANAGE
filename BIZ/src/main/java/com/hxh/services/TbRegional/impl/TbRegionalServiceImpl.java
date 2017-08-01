/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.services.TbRegional.impl;

import com.hxh.dao.TbRegional.TbRegionalDao;
import com.hxh.model.TbRegional;
import com.hxh.services.base.impl.BaseServiceImpl;
import com.hxh.services.TbRegional.TbRegionalService;

import java.util.List;

public class TbRegionalServiceImpl extends BaseServiceImpl<TbRegional> implements TbRegionalService {

	private TbRegionalDao tbRegionalDao = null;


	public void setTbRegionalDao(TbRegionalDao tbRegionalDao) {
		this.tbRegionalDao = tbRegionalDao;
	}	


	public String save(TbRegional model) throws Exception {


		return tbRegionalDao.save(model);
	}


	public boolean  update(TbRegional model) throws Exception {

		return tbRegionalDao.update(model);
	}


	public String deleteById(String id) throws Exception {


		return tbRegionalDao.deleteById(id);

	}


	public TbRegional queryById(String id) throws Exception {

		return tbRegionalDao.queryById(id);
	}


	public List listAll() throws Exception {
			return 	tbRegionalDao.listAll();
	}

	public List listRegional (String parentId) throws Exception {
		return tbRegionalDao.listRegional(parentId);
	}

	public List listRelateRegional(String regId) throws Exception{
		return tbRegionalDao.listRelateRegional(regId);
	}

}

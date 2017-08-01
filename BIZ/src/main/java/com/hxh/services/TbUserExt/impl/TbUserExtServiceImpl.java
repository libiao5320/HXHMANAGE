

package com.hxh.services.TbUserExt.impl;
import com.hxh.dao.TbUserExt.TbUserExtDao;
import com.hxh.model.TbUserExt;
import com.hxh.services.base.impl.BaseServiceImpl;
import com.hxh.services.TbUserExt.TbUserExtService;

import java.util.List;

public class TbUserExtServiceImpl extends BaseServiceImpl<TbUserExt> implements TbUserExtService {

	private TbUserExtDao tbUserExtDao = null;


	public void setTbUserExtDao(TbUserExtDao tbUserExtDao) {
		this.tbUserExtDao = tbUserExtDao;
	}	


	public String save(TbUserExt model) throws Exception {


		return tbUserExtDao.save(model);
	}


	public boolean  update(TbUserExt model) throws Exception {

		return tbUserExtDao.update(model);
	}


	public String deleteById(String id) throws Exception {


		return tbUserExtDao.deleteById(id);

	}


	public TbUserExt queryById(String id) throws Exception {

		return tbUserExtDao.queryById(id);
	}


	public List listAll() throws Exception {
			return 	tbUserExtDao.listAll();
	}

	public void updatePic(String url) {

	}

}

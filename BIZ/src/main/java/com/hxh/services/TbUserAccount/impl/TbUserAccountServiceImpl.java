
package com.hxh.services.TbUserAccount.impl;

import com.hxh.dao.TbUserAccount.TbUserAccountDao;
import com.hxh.model.TbUserAccount;
import com.hxh.services.base.impl.BaseServiceImpl;
import com.hxh.services.TbUserAccount.TbUserAccountService;

import java.sql.SQLException;
import java.util.List;

public class TbUserAccountServiceImpl extends BaseServiceImpl<TbUserAccount> implements TbUserAccountService {

	private TbUserAccountDao tbUserAccountDao = null;


	public void setTbUserAccountDao(TbUserAccountDao tbUserAccountDao) {
		this.tbUserAccountDao = tbUserAccountDao;
	}	


	public String save(TbUserAccount model) throws Exception {


		return tbUserAccountDao.save(model);
	}


	public boolean  update(TbUserAccount model) throws Exception {

		return tbUserAccountDao.update(model);
	}


	public String deleteById(String id) throws Exception {


		return tbUserAccountDao.deleteById(id);

	}


	public TbUserAccount queryById(String id) throws Exception {

		return tbUserAccountDao.queryById(id);
	}


	public List listAll() throws Exception {
			return 	tbUserAccountDao.listAll();
	}

	public TbUserAccount queryByUserId(Integer userId) throws SQLException {
		return tbUserAccountDao.queryByUserId(userId);

	}
}

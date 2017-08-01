
package com.hxh.services.TbUser.impl;

import com.hxh.dao.TbUser.TbUserDao;
import com.hxh.dao.TbUserAccount.TbUserAccountDao;
import com.hxh.dao.TbUserExt.TbUserExtDao;
import com.hxh.model.TbUser;
import com.hxh.model.TbUserAccount;
import com.hxh.model.TbUserExt;
import com.hxh.services.TbUser.TbUserService;
import com.hxh.services.base.impl.BaseServiceImpl;

import java.util.List;
import java.util.Map;

public class TbUserServiceImpl extends BaseServiceImpl<TbUser> implements TbUserService {

	private TbUserDao tbUserDao = null;
	private TbUserExtDao tbUserExtDao = null;
	private TbUserAccountDao tbUserAccountDao = null;

	public void setTbUserDao(TbUserDao tbUserDao) {
		this.tbUserDao = tbUserDao;
	}

	public void setTbUserExtDao(TbUserExtDao tbUserExtDao) {
		this.tbUserExtDao = tbUserExtDao;
	}

	public void setTbUserAccountDao(TbUserAccountDao tbUserAccountDao) {
		this.tbUserAccountDao = tbUserAccountDao;
	}

	public String save(TbUser model) throws Exception {
		String userId =  tbUserDao.save(model);

		TbUserAccount userAccount = new TbUserAccount();
		userAccount.setUserId(Integer.parseInt(userId));
		userAccount.setAccountStatus(1);
		userAccount.setAccountBal(0d);
		tbUserAccountDao.save(userAccount);

		TbUserExt userExt = new TbUserExt();
		userExt.setUserId(Integer.parseInt(userId));
		String maxNoOld = tbUserExtDao.getMaxNo();
		//×ó²¹Áãµ½Ê®Î»
		String maxNo = String.format("%010d",Integer.parseInt(maxNoOld) + 1);
		userExt.setUserNumber(maxNo);
		tbUserExtDao.save(userExt);

		return userId;
	}

	public boolean update(TbUser model) throws Exception {

		return tbUserDao.update(model);
	}

	public boolean update(TbUser model, TbUserExt tbUserExt) throws Exception{

		boolean isUpdate;

		isUpdate = tbUserExtDao.update(tbUserExt);

		if (!isUpdate) {
			return isUpdate;
		} else {
			return tbUserDao.update(model);
		}
	}


	public String deleteById(String id) throws Exception {


		return tbUserDao.deleteById(id);

	}


	public TbUser queryById(String id) throws Exception {

		return tbUserDao.queryById(id);
	}


	public List listAll() throws Exception {
		return 	tbUserDao.listAll();
	}

	public List listUser(Map<String,Object> paramMap) throws Exception{
		return tbUserDao.listUser(paramMap);
	}

}

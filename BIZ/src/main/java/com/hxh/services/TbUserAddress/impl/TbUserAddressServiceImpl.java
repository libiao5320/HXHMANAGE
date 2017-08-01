

package com.hxh.services.TbUserAddress.impl;
import com.hxh.dao.TbUserAddress.TbUserAddressDao;
import com.hxh.model.TbUserAddress;
import com.hxh.services.base.impl.BaseServiceImpl;
import com.hxh.services.TbUserAddress.TbUserAddressService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TbUserAddressServiceImpl extends BaseServiceImpl<TbUserAddress> implements TbUserAddressService {

	private TbUserAddressDao tbUserAddressDao = null;


	public void setTbUserAddressDao(TbUserAddressDao tbUserAddressDao) {
		this.tbUserAddressDao = tbUserAddressDao;
	}	


	public String save(TbUserAddress model) throws Exception {

		String id = tbUserAddressDao.save(model);

		// 重置默认地址
		tbUserAddressDao.updateAllUserAddState(model);

		// 设置默认地址
		model.setAddressId(Integer.parseInt(id));
		tbUserAddressDao.updateUserAddState(model);

		return id;
	}


	public boolean update(TbUserAddress model) throws Exception {

		if (model.getAddressStatus() == 0) {
			// 重置默认地址
			tbUserAddressDao.updateAllUserAddState(model);

			// 设置默认地址
			tbUserAddressDao.updateUserAddState(model);
		}

		return tbUserAddressDao.update(model);
	}


	public String deleteById(String id) throws Exception {


		return tbUserAddressDao.deleteById(id);

	}


	public TbUserAddress queryById(String id) throws Exception {

		return tbUserAddressDao.queryById(id);
	}


	public List listAll() throws Exception {
			return 	tbUserAddressDao.listAll();
	}

	public List listUserAddr(TbUserAddress model) throws Exception {
		return tbUserAddressDao.listUserAddr(model);
	}

	public List listUserAddByUserId(Integer userId) throws SQLException {
		return tbUserAddressDao.listUserAddByUserId(userId);
	}

	public Map getDefaultUserAddByUserId(Integer userId) throws SQLException {
		return tbUserAddressDao.getDefaultUserAddByUserId(userId);
	}

	public Map getFullAddressById(Integer addressId) throws SQLException {
		return tbUserAddressDao.getFullAddressById(addressId);
	}

	public Integer updateAllUserAddState(TbUserAddress model) throws Exception {
		return tbUserAddressDao.updateAllUserAddState(model);
	}

	public Integer updateUserAddState(TbUserAddress model) throws Exception {
		return tbUserAddressDao.updateUserAddState(model);
	}

	public String getNewUserAddressId(TbUserAddress model) throws Exception {
		return tbUserAddressDao.getNewUserAddressId(model);
	}

	public String deleteById(TbUserAddress model) throws Exception{

		String id = tbUserAddressDao.deleteById(model.getAddressId().toString());

		// 如果删除默认地址，则设置用户最新添加地址为默认地址
		if (model.getAddressStatus() == 0) {
			String adrId = getNewUserAddressId(model);
			if (adrId != null) {
				model.setAddressId(Integer.parseInt(adrId));
				updateUserAddState(model);
			}
		}

		return id;
	}

}



package com.hxh.dao.TbUserAddress;


import com.hxh.dao.Base.BaseDao;
import com.hxh.model.TbUserAddress;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface TbUserAddressDao extends BaseDao<TbUserAddress> {
	public List listUserAddr(TbUserAddress model) throws SQLException;
	public List listUserAddByUserId(Integer userId) throws SQLException;
	public Map getDefaultUserAddByUserId(Integer userId) throws SQLException;
	public Map getFullAddressById(Integer addressId) throws SQLException;

	public Integer updateAllUserAddState(TbUserAddress model)throws SQLException;

	public Integer updateUserAddState(TbUserAddress model)throws SQLException;

	public String getNewUserAddressId(TbUserAddress model) throws SQLException;

}

package com.hxh.services.TbUserAddress;

import com.hxh.model.TbUserAddress;
import com.hxh.services.base.BaseService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface TbUserAddressService extends BaseService<TbUserAddress> {
    public List listUserAddr(TbUserAddress model) throws Exception;

    public List listUserAddByUserId(Integer userId) throws SQLException;

    public Map getDefaultUserAddByUserId(Integer userId) throws SQLException;

    public Map getFullAddressById(Integer addressId) throws SQLException;
    public Integer updateAllUserAddState(TbUserAddress model) throws Exception;

    public Integer updateUserAddState(TbUserAddress model) throws Exception;

    public String getNewUserAddressId(TbUserAddress model) throws Exception;

    public String deleteById(TbUserAddress model) throws Exception;
}

package com.hxh.services.TbUserAccount;

import com.hxh.model.TbUserAccount;
import com.hxh.services.base.BaseService;

import java.sql.SQLException;

public interface TbUserAccountService extends BaseService<TbUserAccount> {



        public TbUserAccount queryByUserId(Integer userId) throws SQLException;
}

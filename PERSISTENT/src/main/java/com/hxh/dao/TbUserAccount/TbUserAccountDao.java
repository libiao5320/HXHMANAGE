

package com.hxh.dao.TbUserAccount;

import com.hxh.dao.Base.BaseDao;
import com.hxh.model.TbUserAccount;

import java.sql.SQLException;

public interface TbUserAccountDao extends BaseDao<TbUserAccount> {

    public TbUserAccount queryByUserId(Integer userId) throws SQLException;
}

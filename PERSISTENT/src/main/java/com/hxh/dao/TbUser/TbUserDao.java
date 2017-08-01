

package com.hxh.dao.TbUser;


import com.hxh.dao.Base.BaseDao;
import com.hxh.model.TbUser;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface TbUserDao extends BaseDao<TbUser> {
    public List listUser(Map<String,Object> paramMap) throws SQLException;

}

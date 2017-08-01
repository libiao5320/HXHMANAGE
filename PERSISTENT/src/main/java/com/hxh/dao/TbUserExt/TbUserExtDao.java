
package com.hxh.dao.TbUserExt;


import com.hxh.dao.Base.BaseDao;
import com.hxh.model.TbUserExt;

import java.sql.SQLException;


public interface TbUserExtDao extends BaseDao<TbUserExt> {
    public String getMaxNo() throws SQLException;

}

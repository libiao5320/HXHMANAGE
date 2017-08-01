

package com.hxh.dao.TbRegional;

import com.hxh.dao.Base.BaseDao;
import com.hxh.model.TbRegional;

import java.sql.SQLException;
import java.util.List;

public interface TbRegionalDao extends BaseDao<TbRegional> {
	public List listRegional(String parentId) throws SQLException;
	public List listRelateRegional(String regId) throws SQLException;
}

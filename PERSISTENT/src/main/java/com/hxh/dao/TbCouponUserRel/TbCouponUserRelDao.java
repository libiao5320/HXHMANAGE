/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.dao.TbCouponUserRel;


import com.hxh.dao.Base.BaseDao;
import com.hxh.model.TbCouponUserRel;
import com.ibatis.sqlmap.engine.mapping.sql.Sql;

import java.sql.SQLException;
import java.util.List;

public interface TbCouponUserRelDao extends BaseDao<TbCouponUserRel> {
    public List<TbCouponUserRel> queryCouponListByUserId(Integer userId) throws SQLException;

}

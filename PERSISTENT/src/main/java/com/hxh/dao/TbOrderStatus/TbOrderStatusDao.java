/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.dao.TbOrderStatus;

import com.hxh.dao.Base.BaseDao;
import com.hxh.model.TbOrderStatus;

import java.sql.SQLException;
import java.util.List;

public interface TbOrderStatusDao extends BaseDao<TbOrderStatus> {

    public List queryStatusListByOrderId(String orderId) throws SQLException;
}

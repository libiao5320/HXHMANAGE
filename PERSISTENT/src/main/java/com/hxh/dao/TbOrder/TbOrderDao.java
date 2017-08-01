/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.dao.TbOrder;



/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


import com.hxh.dao.Base.BaseDao;
import com.hxh.model.TbOrder;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface TbOrderDao extends BaseDao<TbOrder> {
    /**
     * 根据条件查询订单列表
     * @param order 订单条件
     * @return 订单列表
     * @throws SQLException SQL异常
     */
    public List queryOrderList(TbOrder order) throws SQLException;

    /**
     * 查询订单是否已存在
     * @param seq 订单编号
     * @return true 存在,false 不存在
     * @throws SQLException SQL异常
     */
    public boolean getBySeq(String seq) throws SQLException;


    public List queryOrderByUserId(Integer userId)throws  SQLException;

    public List manageListOrder(String type)throws  SQLException;
    public List manageListOrder(Map params)throws  SQLException;
    public boolean delOrder(String orderId)throws  SQLException;

    public Map queryOrderDetail(String orderId)throws SQLException;




	
}

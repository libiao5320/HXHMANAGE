package com.hxh.services.TbOrder;

import com.hxh.model.TbOrder;
import com.hxh.model.TbOrderBaseInfo;
import com.hxh.model.TbOrderStatus;
import com.hxh.services.base.BaseService;

import java.lang.String;
import java.util.List;
import java.util.Map;

public interface TbOrderService extends BaseService<TbOrder> {

    /**
     * 用户下单
     * @param order 订单
     * @param orderlInfo 订单基础信息
     * @param orderStatus 订单状态
     * @return 订单主键
     * @throws Exception 异常
     */
    public String save(TbOrder order, TbOrderBaseInfo orderlInfo, TbOrderStatus orderStatus) throws Exception;

    /**
     * 更新订单状态
     * @param order 订单
     * @param orderStatus 订单状态
     * @throws Exception 异常
     */
    public void updateStatus(TbOrder order, TbOrderStatus orderStatus) throws Exception;

    /**
     * 根据条件查询订单列表
     * @param order 订单
     * @return 订单列表
     * @throws Exception 异常
     */
    public List queryOrderList(TbOrder order) throws Exception;


    /**
     * 根据用户ID查询订单列表
     * @param userId
     * @return
     * @throws Exception
     */
    public List queryOrderListByUserId(Integer userId) throws Exception;



    /**
     * 客服订单管理页面接口
     * @param userId
     * @return
     * @throws Exception
     */
    public List manageListOrder(String type ) throws Exception;



    /**
     * 客服订单管理页面接口根据条件查询
     * @param userId
     * @return
     * @throws Exception
     */
    public List manageListOrder(Map params ) throws Exception;



    /**
     * 客服订单管理页面删除订单接口
     * @param userId
     * @return
     * @throws Exception
     */
    public boolean delOrder(String orderId) throws Exception;



    public Map queryOrderDetail(String orderId) throws  Exception;



    public boolean checkOrder(List proList,TbOrder order,String chkId)throws  Exception;



}

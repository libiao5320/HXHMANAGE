package com.hxh.services.TbOrderStatus;

import com.hxh.model.TbOrderStatus;
import com.hxh.services.base.BaseService;

import java.util.List;

public interface TbOrderStatusService extends BaseService<TbOrderStatus> {

    public List queryStatusListByOrderId(String orderId) throws Exception;
}

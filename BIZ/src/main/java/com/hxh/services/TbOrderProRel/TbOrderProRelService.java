package com.hxh.services.TbOrderProRel;

import com.hxh.model.TbOrderProRel;
import com.hxh.services.base.BaseService;

import java.util.List;

public interface TbOrderProRelService extends BaseService<TbOrderProRel> {

    public List queryProductListByOrderId(String orderId) throws Exception;
}

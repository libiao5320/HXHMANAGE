package com.hxh.services.TbCouponUserRel;

import com.hxh.model.TbCouponUserRel;
import com.hxh.services.base.BaseService;

import java.util.List;

public interface TbCouponUserRelService extends BaseService<TbCouponUserRel> {
	
	        public List queryCouponListByUserId(Integer userId) throws Exception;
}

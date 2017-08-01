package com.hxh.services.TbUserExt;

import com.hxh.model.TbUserExt;
import com.hxh.services.base.BaseService;

public interface TbUserExtService extends BaseService<TbUserExt> {
	
	public void updatePic(String url);
}

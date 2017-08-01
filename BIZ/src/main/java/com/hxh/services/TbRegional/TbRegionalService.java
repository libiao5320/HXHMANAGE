package com.hxh.services.TbRegional;

import com.hxh.model.TbRegional;
import com.hxh.services.base.BaseService;

import java.util.List;

public interface TbRegionalService extends BaseService<TbRegional> {
    public List listRegional(String parentId) throws Exception;
    public List listRelateRegional(String regId) throws Exception;
}

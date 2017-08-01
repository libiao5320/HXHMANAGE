package com.hxh.services.TbUser;


import com.hxh.model.TbUser;
import com.hxh.model.TbUserExt;
import com.hxh.services.base.BaseService;

import java.util.List;
import java.util.Map;

public interface TbUserService extends BaseService<TbUser> {


    List listUser(Map<String,Object> paramMap) throws Exception;

    boolean update(TbUser tbUser, TbUserExt tbUserExt) throws Exception;

}

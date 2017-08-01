package com.hxh.services.base.impl;


import com.hxh.model.BaseEntity;
import com.hxh.services.base.BaseService;

import java.util.List;

public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T>
{

    public String save(T t) throws Exception {
        return null;
    }

    public boolean update(T t) throws Exception {
        return false;
    }

    public String deleteById(String id) throws Exception {
        return null;
    }

    public T queryById(String id) throws Exception {
        return null;
    }

    public List listAll() throws Exception {
        return null;
    }
}
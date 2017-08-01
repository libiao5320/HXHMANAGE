package com.hxh.services.TbDiser;

import com.hxh.model.TbDiser;
import com.hxh.services.base.BaseService;

import java.util.List;
import java.util.Map;

public interface TbDiserService extends BaseService<TbDiser> {

    public boolean goodDiser(String disId) throws Exception;

    public boolean badDiser(String disId) throws Exception;

    public List listAll() throws Exception;

    public void saveDiser(TbDiser tbDiser,String loadPath) throws Exception;

    void relComm(String disId, String str)throws Exception;

    public List manageListDiser(Map params ) throws Exception;

    String deleteById(String id,String loadPath) throws Exception;

    boolean  update(TbDiser  model,String loadPath)throws Exception;
}

package com.hxh.services.TbProduct;

import com.hxh.model.TbProduct;
import com.hxh.model.TbProductAttr;
import com.hxh.services.base.BaseService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface TbProductService extends BaseService<TbProduct> {
    public List getPriceList() throws SQLException;

    public List manageProList() throws SQLException;

    public List queryAttrByProId(String proId) throws SQLException;
    public TbProductAttr queryAttrById(String attrId) throws SQLException;

    public List manageProTypeList() throws SQLException;
    public List queryAllProType() throws SQLException;
    public List queryProductByCondition(Map paramMap) throws SQLException;


    public String addProAttr(TbProductAttr attr) throws SQLException;
    public boolean editProAttr(TbProductAttr attr) throws SQLException;
    public boolean delProAttr(String proAttrId) throws SQLException;

}

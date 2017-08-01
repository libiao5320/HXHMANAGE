

package com.hxh.services.TbCommunity;


import com.hxh.model.TbCommunity;
import com.hxh.services.base.BaseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TbCommunityService extends BaseService<TbCommunity> {

    public String save(TbCommunity model,String Ids) throws Exception;
    public boolean update(TbCommunity model,String Ids) throws Exception;

    /**
     * 根据指定地域，查询小区列表，有关键字时，做模糊匹配
     * @param model 地域ID，小区名称
     * @return 小区列表
     * @throws Exception 异常
     */
    public List listRegComm(TbCommunity model) throws Exception;

    /**
     * 模糊匹配小区列表，显示小区省市区
     * @param searchValue 查询名称
     * @return 小区列表
     * @throws Exception 异常
     */
    public List queryFullComm(Map searchValue) throws Exception;

    /**
     * 查询附近小区
     * @param map 经纬度集合
     * @return
     * @throws Exception 异常
     */
    public List queryNearComm(HashMap<String, Double> map) throws Exception;

    /**
     * 通过小区ID查询小区，显示小区省市区
     * @param commId
     * @return
     * @throws Exception
     */
    public Map<String,String> getCommunityById(String commId) throws Exception;

}
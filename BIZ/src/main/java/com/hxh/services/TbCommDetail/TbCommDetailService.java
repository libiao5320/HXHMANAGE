package com.hxh.services.TbCommDetail;

import com.hxh.model.TbCommDetail;
import com.hxh.services.base.BaseService;

import java.util.List;

public interface TbCommDetailService extends BaseService<TbCommDetail> {

    /**
     * 根据指定小区，查询小区单元号等信息，有关键字时，做模糊匹配
     * @param model 小区ID，地址描述
     * @return 详细地址描述
     * @throws Exception 异常
     */
    public List listCommDetail(TbCommDetail model) throws Exception;

    /**
     * 根据指定小区，查询小区单元号等信息
     * @param commId 小区ID，地址描述
     * @return 详细地址描述
     * @throws Exception 异常
     */
    public List listCommDetail(Integer commId) throws Exception;

    /**
     * 获得小区明细ID列表
     * @return 明细ID列表
     * @throws Exception 异常
     */
    public List<String> getIds() throws Exception;
}

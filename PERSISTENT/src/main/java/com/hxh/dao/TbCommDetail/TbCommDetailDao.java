
package com.hxh.dao.TbCommDetail;


import com.hxh.dao.Base.BaseDao;
import com.hxh.model.TbCommDetail;

import java.sql.SQLException;
import java.util.List;

public interface TbCommDetailDao extends BaseDao<TbCommDetail> {

    /**
     * 根据指定小区，查询小区单元号等信息，有关键字时，做模糊匹配
     * @param model 小区ID，地址描述
     * @return 详细地址描述
     * @throws Exception 异常
     */
    public List listCommDetail(TbCommDetail model) throws SQLException;

    /**
     * 根据指定小区，查询小区单元号等信息
     * @param commId 小区ID，地址描述
     * @return 详细地址描述
     * @throws Exception 异常
     */
    public List queryCommDetailByCommId(Integer commId) throws SQLException;

    /**
     * 获得小区明细ID列表
     * @return 明细ID列表
     * @throws SQLException 异常
     */
    public List<String> getIds() throws SQLException;

    /**
     * 根据小区ID删除小区明细
     * @return
     * @throws SQLException
     */
    public int deleteByCommId(String commId) throws SQLException;
}

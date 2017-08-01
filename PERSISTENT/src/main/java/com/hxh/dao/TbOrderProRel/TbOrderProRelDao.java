

package com.hxh.dao.TbOrderProRel;


import com.hxh.dao.Base.BaseDao;
import com.hxh.model.TbOrderProRel;

import java.sql.SQLException;
import java.util.List;

public interface TbOrderProRelDao extends BaseDao<TbOrderProRel> {


    List queryProductListByOrderId(String orderId) throws SQLException;
}

package com.hxh.services.TbDisCommRel;

import com.hxh.model.TbDisCommRel;
import com.hxh.services.base.BaseService;

import java.sql.SQLException;
import java.util.List;

public interface TbDisCommRelService extends BaseService<TbDisCommRel> {

    public TbDisCommRel getByCommId(String commId) throws Exception;
    public List<TbDisCommRel> getByDisId(String disId) throws Exception;

  /*  TbDisCommRel queryByCommIdDiserId(String disId, String commId) throws SQLException;*/
  String delCommRel(String disId, String commId) throws SQLException;

}

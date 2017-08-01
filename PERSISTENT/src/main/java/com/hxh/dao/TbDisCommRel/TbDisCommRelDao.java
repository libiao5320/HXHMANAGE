

package com.hxh.dao.TbDisCommRel;

import com.hxh.dao.Base.BaseDao;
import com.hxh.model.TbDisCommRel;

import java.sql.SQLException;
import java.util.List;


public interface TbDisCommRelDao extends BaseDao<TbDisCommRel> {

    public TbDisCommRel getByCommId(String commId) throws SQLException;
    public TbDisCommRel queryByCommIdDiserId(TbDisCommRel tbDisCommRel) throws SQLException;
    public List<TbDisCommRel> getByDisId(String commId) throws SQLException;

    String deleteByDisId(String i) throws SQLException;

    String delCommRel(TbDisCommRel tbD) throws SQLException;

    String save (List<TbDisCommRel> disCommRels) throws SQLException;

    String deleteByCommId(String commId) throws SQLException;
}

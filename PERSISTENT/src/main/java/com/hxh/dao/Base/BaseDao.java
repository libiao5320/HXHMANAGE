package com.hxh.dao.Base;

/***********************************************************************
 * Module:  BaseDao.java
 * Author:  Administrator
 * Purpose: Defines the Interface BaseDao
 ***********************************************************************/


import com.hxh.model.BaseEntity;

import java.sql.SQLException;
import java.util.List;

/** @pdOid b5d73630-26e9-4ffa-96fb-0df1c7530986 */
public interface BaseDao<T extends BaseEntity> {
   /** @param t
    * @pdOid 7ef11a7a-d92a-4ed7-8a11-a86a55a94650 */
   String save(T t) throws SQLException;
   /** @param t
    * @pdOid b8e6bc18-0489-4c9b-bab7-570f105ba21e */
   boolean update(T t) throws SQLException;
   /** @param id
    * @pdOid e3e1002a-30b1-41d8-bfca-2864502f388c */
   String deleteById(String id) throws SQLException;
   /** @param id
    * @pdOid bbd33fb2-0191-4082-a938-c878dfba14c1 */
   T queryById(String id) throws SQLException;
   /** @pdOid 8ad867f7-82a2-47e4-88b9-8b118e8a1970 */
   List listAll() throws SQLException;

}
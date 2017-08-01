package com.hxh.services.base;


import com.hxh.model.BaseEntity;

import java.util.List;

public interface BaseService <T extends BaseEntity>{
	/** @param t
	 * @pdOid 7ef11a7a-d92a-4ed7-8a11-a86a55a94650 */
	String save(T t) throws Exception;
	/** @param t
	 * @pdOid b8e6bc18-0489-4c9b-bab7-570f105ba21e */
	boolean update(T t) throws Exception;
	/** @param id
	 * @pdOid e3e1002a-30b1-41d8-bfca-2864502f388c */
	String deleteById(String id) throws Exception;
	/** @param id
	 * @pdOid bbd33fb2-0191-4082-a938-c878dfba14c1 */
	T queryById(String id) throws Exception;
	/** @pdOid 8ad867f7-82a2-47e4-88b9-8b118e8a1970 */
	List listAll() throws Exception;


}

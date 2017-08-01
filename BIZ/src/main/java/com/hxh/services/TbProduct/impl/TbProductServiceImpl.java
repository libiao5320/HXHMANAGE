

package com.hxh.services.TbProduct.impl;
import com.hxh.dao.TbProduct.TbProductDao;
import com.hxh.model.TbProduct;
import com.hxh.model.TbProductAttr;
import com.hxh.services.TbProduct.TbProductService;
import com.hxh.services.base.impl.BaseServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TbProductServiceImpl extends BaseServiceImpl<TbProduct> implements TbProductService {

	private TbProductDao tbProductDao = null;


	public void setTbProductDao(TbProductDao tbProductDao) {
		this.tbProductDao = tbProductDao;
	}	


	public String save(TbProduct model) throws Exception {


		return tbProductDao.save(model);
	}


	public boolean  update(TbProduct model) throws Exception {

		return tbProductDao.update(model);
	}


	public String deleteById(String id) throws Exception {


		return tbProductDao.deleteById(id);

	}


	public TbProduct queryById(String id) throws Exception {

		return tbProductDao.queryById(id);
	}


	public List listAll() throws Exception {
			return 	tbProductDao.listAll();
	}

	public List getPriceList() throws SQLException {
		List l = tbProductDao.getPriceList();


		return l;



	}

	public List manageProList() throws SQLException {
		return tbProductDao.mangeProList();
	}

	public List queryAttrByProId(String proId) throws SQLException {
		return tbProductDao.queryAttrByProId(proId);
	}

	public TbProductAttr queryAttrById(String attrId) throws SQLException {
		return tbProductDao.queryAttrById(attrId);
	}

	public List manageProTypeList() throws SQLException {
		return tbProductDao.mangeProTypeList();
	}

	public List queryAllProType() throws SQLException {
		return tbProductDao.queryAllProType();
	}

	public List queryProductByCondition(Map paramMap) throws SQLException {
		return tbProductDao.queryProductByCondition(paramMap);
	}

	public String addProAttr(TbProductAttr attr) throws SQLException {
		return tbProductDao.addProAttr(attr);
	}

	public boolean editProAttr(TbProductAttr attr) throws SQLException {
		return tbProductDao.editProAttr(attr);
	}

	public boolean delProAttr(String proAttrId) throws SQLException {
		return tbProductDao.delProAttr(proAttrId);

	}


}

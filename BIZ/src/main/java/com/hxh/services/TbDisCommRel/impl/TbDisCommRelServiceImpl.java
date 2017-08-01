


package com.hxh.services.TbDisCommRel.impl;
import com.hxh.dao.TbDisCommRel.TbDisCommRelDao;
import com.hxh.model.TbDisCommRel;
import com.hxh.services.base.impl.BaseServiceImpl;
import com.hxh.services.TbDisCommRel.TbDisCommRelService;

import java.sql.SQLException;
import java.util.List;

public class TbDisCommRelServiceImpl extends BaseServiceImpl<TbDisCommRel> implements TbDisCommRelService {

	private TbDisCommRelDao tbDisCommRelDao = null;


	public void setTbDisCommRelDao(TbDisCommRelDao tbDisCommRelDao) {
		this.tbDisCommRelDao = tbDisCommRelDao;
	}	


	public String save(TbDisCommRel model) throws Exception {


		return tbDisCommRelDao.save(model);
	}


	public boolean  update(TbDisCommRel model) throws Exception {

		return tbDisCommRelDao.update(model);
	}


	public String deleteById(String id) throws Exception {

		tbDisCommRelDao.deleteByDisId(id);
		return tbDisCommRelDao.deleteById(id);

	}
	public String delCommRel(String disId, String commId) throws SQLException {
		TbDisCommRel tbDisCommRel = new TbDisCommRel();
		tbDisCommRel.setDisId(Integer.valueOf(disId));
		tbDisCommRel.setCommId(Integer.valueOf(commId));

		return tbDisCommRelDao.delCommRel(tbDisCommRel);

	}


	public TbDisCommRel queryById(String id) throws Exception {

		return tbDisCommRelDao.queryById(id);
	}

	public TbDisCommRel queryByCommIdDiserId(String disId,String commId) throws SQLException {
		TbDisCommRel tbDisCommRel = new TbDisCommRel();
		tbDisCommRel.setDisId(Integer.valueOf(disId));
		tbDisCommRel.setCommId(Integer.valueOf(commId));
		return tbDisCommRelDao.queryByCommIdDiserId(tbDisCommRel);
	}


	public List listAll() throws Exception {
			return 	tbDisCommRelDao.listAll();
	}

	public TbDisCommRel getByCommId(String commId) throws Exception{
		return tbDisCommRelDao.getByCommId(commId);
	}

	public List<TbDisCommRel> getByDisId(String diserId) throws Exception{
		return tbDisCommRelDao.getByDisId(diserId);
	}

}

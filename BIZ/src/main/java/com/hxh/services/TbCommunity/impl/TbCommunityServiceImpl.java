

package com.hxh.services.TbCommunity.impl;

import com.hxh.dao.TbCommDetail.TbCommDetailDao;
import com.hxh.dao.TbCommunity.TbCommunityDao;
import com.hxh.dao.TbDisCommRel.TbDisCommRelDao;
import com.hxh.model.TbCommunity;
import com.hxh.model.TbDisCommRel;
import com.hxh.services.TbCommunity.TbCommunityService;
import com.hxh.services.base.impl.BaseServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TbCommunityServiceImpl extends BaseServiceImpl<TbCommunity> implements TbCommunityService {

	private TbCommunityDao tbCommunityDao = null;
	private TbCommDetailDao tbCommDetailDao = null;
	private TbDisCommRelDao tbDisCommRelDao = null;

	public void setTbCommunityDao(TbCommunityDao tbCommunityDao) {
		this.tbCommunityDao = tbCommunityDao;
	}

	public void setTbCommDetailDao(TbCommDetailDao tbCommDetailDao) {
		this.tbCommDetailDao = tbCommDetailDao;
	}

	public void setTbDisCommRelDao(TbDisCommRelDao tbDisCommRelDao) {
		this.tbDisCommRelDao = tbDisCommRelDao;
	}

	public String save(TbCommunity model,String disIds) throws Exception {

		String commId = tbCommunityDao.save(model);

		List<TbDisCommRel> paramList = new ArrayList<TbDisCommRel>();

		String disIdList[] = disIds.split(",");

		for (int i = 0; i < disIdList.length; i++) {
			TbDisCommRel tbDisCommRel = new TbDisCommRel();
			tbDisCommRel.setCommId(Integer.parseInt(commId));
			tbDisCommRel.setDisId(Integer.parseInt(disIdList[i]));
			paramList.add(tbDisCommRel);
		}

		tbDisCommRelDao.save(paramList);

		return commId;
	}


	public boolean update(TbCommunity model,String disIds) throws Exception {

		tbDisCommRelDao.deleteByCommId(model.getCommId().toString());

		List<TbDisCommRel> paramList = new ArrayList<TbDisCommRel>();
		String disIdList[] = disIds.split(",");

		for (int i = 0; i < disIdList.length; i++) {
			TbDisCommRel tbDisCommRel = new TbDisCommRel();
			tbDisCommRel.setCommId(model.getCommId());
			tbDisCommRel.setDisId(Integer.parseInt(disIdList[i]));
			paramList.add(tbDisCommRel);
		}

		tbDisCommRelDao.save(paramList);

		return tbCommunityDao.update(model);
	}


	public String deleteById(String id) throws Exception {
		tbCommDetailDao.deleteByCommId(id);
		tbDisCommRelDao.deleteByCommId(id);

		return tbCommunityDao.deleteById(id);

	}


	public TbCommunity queryById(String id) throws Exception {

		return tbCommunityDao.queryById(id);
	}


	public List listAll() throws Exception {
			return 	tbCommunityDao.listAll();
	}


	public List listRegComm(TbCommunity model) throws Exception {
		return tbCommunityDao.listRegComm(model);
	}

	public List queryFullComm(Map searchValue) throws Exception {
		return tbCommunityDao.queryFullComm(searchValue);
	}

	public List queryNearComm(HashMap<String,Double> map) throws Exception {
		return tbCommunityDao.queryNearComm(map);
	}

	public Map<String,String> getCommunityById(String commId) throws Exception{
		return tbCommunityDao.getCommunityById(commId);
	}
}

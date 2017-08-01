package com.hxh.services.TbDiser.impl;

import com.hxh.dao.TbDisCommRel.TbDisCommRelDao;
import com.hxh.dao.TbDiser.TbDiserDao;
import com.hxh.model.TbDisCommRel;
import com.hxh.model.TbDiser;
import com.hxh.services.TbDiser.TbDiserService;
import com.hxh.services.base.impl.BaseServiceImpl;
import com.hxh.services.util.FtpUtil;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TbDiserServiceImpl extends BaseServiceImpl<TbDiser> implements TbDiserService {

	private TbDiserDao tbDiserDao = null;

	private TbDisCommRelDao tbDisCommRelDao = null;

	public TbDisCommRelDao getTbDisCommRelDao() {
		return tbDisCommRelDao;
	}

	public void setTbDisCommRelDao(TbDisCommRelDao tbDisCommRelDao) {
		this.tbDisCommRelDao = tbDisCommRelDao;
	}

	public void setTbDiserDao(TbDiserDao tbDiserDao) {
		this.tbDiserDao = tbDiserDao;
	}	


	public String save(TbDiser model) throws Exception {
		return tbDiserDao.save(model);
	}


	public boolean  update(TbDiser model,String loadPath) throws Exception {
		TbDiser tbDiser = tbDiserDao.queryById(String.valueOf(model.getDisId()));
		if((tbDiser.getDisPhoto().equals(model.getDisPhone())==false)
				&&(!(model.getDisPhoto() == null) ||"".equals(model.getDisPhoto()) ==false)){
			FtpUtil.delDiserPhoto(tbDiser.getDisPhoto());
			File file = new File(loadPath+model.getDisPhoto());
			FileInputStream in = new FileInputStream(file);
			boolean b = FtpUtil.uploadDiserPhoto(model.getDisPhoto(), in);
			if(b==false){
				return false;
			}
		}
		return tbDiserDao.update(model);
	}


	public String deleteById(String id,String uploadPath) throws Exception {
		TbDiser tbDiser = tbDiserDao.queryById(id);
		File file = new File(uploadPath+tbDiser.getDisPhoto());
		if(file.isFile() && file.exists()){
			file.delete();
		//	logger.info("删除文件" + tbDiser.getDisPhoto() + "成功�?");
		}else{
		//	logger.info("删除文件"+tbDiser.getDisPhoto()+"失败�?");
		}
		FtpUtil.delDiserPhoto(tbDiser.getDisPhoto());
		return tbDiserDao.deleteById(id);

	}

	public List manageListDiser(Map params) throws Exception{

		return tbDiserDao.manageListDiser(params);}





	public TbDiser queryById(String id) throws Exception {

		return tbDiserDao.queryById(id);
	}


	public List listAll() throws Exception {
			return 	tbDiserDao.listAll();
	}

	public void saveDiser(TbDiser tbDiser,String loadPath) throws Exception {
	if(tbDiser.getDisPhoto()!=null){
		File file = new File(loadPath+tbDiser.getDisPhoto());
		FileInputStream in = new FileInputStream(file);
		boolean  boo = FtpUtil.uploadDiserPhoto(tbDiser.getDisPhoto(), in);
	}
		Random random = new Random();
		tbDiser.setDisWorknum("CS" + random.nextInt(10000));
		tbDiserDao.save(tbDiser);

	}

	public void relComm(String disId, String str)throws Exception {
		String[] aa = str.substring(0, str.length() - 1).split(",");
		for(int i=0;i<aa.length;i++){
			TbDisCommRel tbDisCommRel = new TbDisCommRel();
			tbDisCommRel.setCommId(Integer.valueOf(aa[i]));
			tbDisCommRel.setDisId(Integer.valueOf(disId));
			tbDisCommRelDao.save(tbDisCommRel);
		}

	}

	public boolean goodDiser(String disId) throws Exception {
		return tbDiserDao.goodDiser(disId);
	}

	public boolean badDiser(String disId) throws Exception {
		return tbDiserDao.badDiser(disId);
	}
}

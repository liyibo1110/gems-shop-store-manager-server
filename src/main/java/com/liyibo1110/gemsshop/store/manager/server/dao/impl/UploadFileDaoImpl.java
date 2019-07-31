package com.liyibo1110.gemsshop.store.manager.server.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.liyibo1110.gemsshop.store.manager.server.dao.AbstractDao;
import com.liyibo1110.gemsshop.store.manager.server.dao.UploadFileDao;
import com.liyibo1110.gemsshop.store.manager.server.entity.UploadFile;

/**
 * 
 * @author liyibo
 *
 */
@Repository
public class UploadFileDaoImpl extends AbstractDao implements UploadFileDao{

	private static Logger logger = LoggerFactory.getLogger(UploadFileDaoImpl.class);
	
	@Override
	public List<UploadFile> getList(Integer storeId, Integer groupId){
		UploadFileDao dao = gemsShopSqlSessionTemplate.getMapper(UploadFileDao.class);
		return dao.getList(storeId, groupId);
	}
	
	@Override
	public List<UploadFile> getByGoodId(Integer storeId, Integer goodId){
		UploadFileDao dao = gemsShopSqlSessionTemplate.getMapper(UploadFileDao.class);
		return dao.getByGoodId(storeId, goodId);
	}
	
	@Override
	public int modify(Integer storeId, String ids, Integer groupId) {
		UploadFileDao dao = gemsShopSqlSessionTemplate.getMapper(UploadFileDao.class);
		return dao.modify(storeId, ids, groupId);
	}
	
	@Override
	public int create(Integer storeId, Integer storage,
			  		String fileUrl, String fileName,
			  		Long fileSize, Integer fileType,
			  		String extension) {
		UploadFileDao dao = gemsShopSqlSessionTemplate.getMapper(UploadFileDao.class);
		return dao.create(storeId, storage, fileUrl, fileName, fileSize, 
								fileType, extension);
	}
	
}

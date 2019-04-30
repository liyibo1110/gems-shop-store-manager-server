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
		UploadFileDao uploadFileDao = gemsShopSqlSessionTemplate.getMapper(UploadFileDao.class);
		return uploadFileDao.getList(storeId, groupId);
	}
	
	@Override
	public List<UploadFile> getByGoodId(Integer storeId, Integer goodId){
		UploadFileDao uploadFileDao = gemsShopSqlSessionTemplate.getMapper(UploadFileDao.class);
		return uploadFileDao.getByGoodId(storeId, goodId);
	}
	
	@Override
	public int modify(Integer storeId, String ids, Integer groupId) {
		UploadFileDao uploadFileDao = gemsShopSqlSessionTemplate.getMapper(UploadFileDao.class);
		return uploadFileDao.modify(storeId, ids, groupId);
	}
	
	@Override
	public int create(Integer storeId, Integer storage,
			  		String fileUrl, String fileName,
			  		Long fileSize, Integer fileType,
			  		String extension) {
		UploadFileDao uploadFileDao = gemsShopSqlSessionTemplate.getMapper(UploadFileDao.class);
		return uploadFileDao.create(storeId, storage, fileUrl, fileName, fileSize, 
								fileType, extension);
	}
	
}

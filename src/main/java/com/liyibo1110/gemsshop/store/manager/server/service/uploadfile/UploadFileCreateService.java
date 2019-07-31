package com.liyibo1110.gemsshop.store.manager.server.service.uploadfile;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;

/**
 * 
 * @author liyibo
 *
 */
@Service
public class UploadFileCreateService extends BaseUploadFileService{

	private static Logger logger = LoggerFactory.getLogger(UploadFileCreateService.class);
	
	public int create(StoreUser user, String fileName, Long fileSize){  
		//写死一些字段
		Integer storage = 1;
		String fileUrl = "";
		Integer fileType = 1;
		String extension = StringUtils.substringAfter(fileName, ".");
		return uploadFileDao.create(user.getStoreId(), storage, fileUrl, fileName, fileSize, 
									fileType, extension);
	}
}

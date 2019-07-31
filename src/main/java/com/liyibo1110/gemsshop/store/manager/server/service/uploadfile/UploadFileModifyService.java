package com.liyibo1110.gemsshop.store.manager.server.service.uploadfile;

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
public class UploadFileModifyService extends BaseUploadFileService{

	private static Logger logger = LoggerFactory.getLogger(UploadFileModifyService.class);
	
	public int modify(StoreUser user, String ids, Integer groupId){  
		
		return uploadFileDao.modify(user.getStoreId(), ids, groupId);
	}
}

package com.liyibo1110.gemsshop.store.manager.server.service.uploadfile;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;
import com.liyibo1110.gemsshop.store.manager.server.entity.UploadFile;

@Service
public class UploadFileListService extends BaseUploadFileService{

	private static Logger logger = LoggerFactory.getLogger(UploadFileListService.class);
	
	public List<UploadFile> list(StoreUser user, Integer groupId){
		
		if(groupId != null && groupId == -1) {
			groupId = null;
		}
		return uploadFileDao.getList(user.getStoreId(), groupId);
	}
}

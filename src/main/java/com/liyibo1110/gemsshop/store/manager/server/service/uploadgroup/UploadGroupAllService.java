package com.liyibo1110.gemsshop.store.manager.server.service.uploadgroup;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;
import com.liyibo1110.gemsshop.store.manager.server.entity.UploadGroup;

@Service
public class UploadGroupAllService extends BaseUploadGroupService{

	private static Logger logger = LoggerFactory.getLogger(UploadGroupAllService.class);
	
	public List<UploadGroup> all(StoreUser user){
		
		return uploadGroupDao.getAll(user.getStoreId());
	}
}

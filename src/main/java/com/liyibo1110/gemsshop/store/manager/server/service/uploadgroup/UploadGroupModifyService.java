package com.liyibo1110.gemsshop.store.manager.server.service.uploadgroup;

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
public class UploadGroupModifyService extends BaseUploadGroupService{

	private static Logger logger = LoggerFactory.getLogger(UploadGroupModifyService.class);
	
	public int modify(StoreUser user, Integer id, String name){  
		return uploadGroupDao.modify(user.getStoreId(), id, name);
	}
}

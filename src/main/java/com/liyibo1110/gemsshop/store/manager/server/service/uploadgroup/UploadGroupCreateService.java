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
public class UploadGroupCreateService extends BaseUploadGroupService{

	private static Logger logger = LoggerFactory.getLogger(UploadGroupCreateService.class);
	
	public int create(StoreUser user, Integer type, String name, Integer sort){  
		//写死type和sort
		type = 1;
		sort = 100;
		return uploadGroupDao.create(user.getStoreId(), type, name, sort);
	}
}

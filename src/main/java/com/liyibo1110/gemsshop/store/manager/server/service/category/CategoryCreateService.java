package com.liyibo1110.gemsshop.store.manager.server.service.category;

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
public class CategoryCreateService extends BaseCategoryService{

	private static Logger logger = LoggerFactory.getLogger(CategoryCreateService.class);
	
	public int create(StoreUser user, String name, Integer sort){  
		return categoryDao.create(user.getStoreId(), name, sort);
	}
}

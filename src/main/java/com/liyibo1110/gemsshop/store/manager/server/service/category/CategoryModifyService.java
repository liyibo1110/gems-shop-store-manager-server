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
public class CategoryModifyService extends BaseCategoryService{

	private static Logger logger = LoggerFactory.getLogger(CategoryModifyService.class);
	
	public int modify(StoreUser user, Integer id, String name, Integer sort){  
		return categoryDao.modify(user.getStoreId(), id, name, sort);
	}
}

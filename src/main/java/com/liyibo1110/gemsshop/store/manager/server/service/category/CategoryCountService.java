package com.liyibo1110.gemsshop.store.manager.server.service.category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;

@Service
public class CategoryCountService extends BaseCategoryService{

	private static Logger logger = LoggerFactory.getLogger(CategoryCountService.class);
	
	public Integer count(StoreUser user, String name){
		
		Integer count = categoryDao.getCount(user.getStoreId(), name);
		if(count == null) {
			return 0;
		}else {
			return count;
		}
	}
}

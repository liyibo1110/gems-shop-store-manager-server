package com.liyibo1110.gemsshop.store.manager.server.service.category;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.Category;
import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;

@Service
public class CategoryAllService extends BaseCategoryService{

	private static Logger logger = LoggerFactory.getLogger(CategoryAllService.class);
	
	public List<Category> all(StoreUser user){
		
		return categoryDao.getAll(user.getStoreId());
	}
}

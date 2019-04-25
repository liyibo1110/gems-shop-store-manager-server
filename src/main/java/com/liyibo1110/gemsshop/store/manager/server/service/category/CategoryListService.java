package com.liyibo1110.gemsshop.store.manager.server.service.category;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.Category;
import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;

@Service
public class CategoryListService extends BaseCategoryService{

	private static Logger logger = LoggerFactory.getLogger(CategoryListService.class);
	
	public List<Category> list(StoreUser user, String name, 
							Integer limit, Integer offset){
	
		return categoryDao.getList(user.getStoreId(), name, limit, offset);
	}
}

package com.liyibo1110.gemsshop.store.manager.server.service.category;

import org.springframework.beans.factory.annotation.Autowired;

import com.liyibo1110.gemsshop.store.manager.server.dao.CategoryDao;
import com.liyibo1110.gemsshop.store.manager.server.service.BaseService;

public class BaseCategoryService extends BaseService{

	@Autowired
	protected CategoryDao categoryDao;
}

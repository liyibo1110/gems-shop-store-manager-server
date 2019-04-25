package com.liyibo1110.gemsshop.store.manager.server.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.liyibo1110.gemsshop.store.manager.server.dao.AbstractDao;
import com.liyibo1110.gemsshop.store.manager.server.dao.CategoryDao;
import com.liyibo1110.gemsshop.store.manager.server.entity.Category;

/**
 * 
 * @author liyibo
 *
 */
@Repository
public class CategoryDaoImpl extends AbstractDao implements CategoryDao{

	private static Logger logger = LoggerFactory.getLogger(CategoryDaoImpl.class);
	
	public List<Category> getList(Integer storeId, String name, 
								Integer limit, Integer offset){
		CategoryDao categoryDao = gemsShopSqlSessionTemplate.getMapper(CategoryDao.class);
		return categoryDao.getList(storeId, name, limit, offset);
	}

	public int getCount(Integer storeId, String name) {
		CategoryDao categoryDao = gemsShopSqlSessionTemplate.getMapper(CategoryDao.class);
		return categoryDao.getCount(storeId, name);
	}
	
	public int create(Integer storeId, String name,
			 		Integer sort) {
		CategoryDao categoryDao = gemsShopSqlSessionTemplate.getMapper(CategoryDao.class);
		return categoryDao.create(storeId, name, sort);
	}

	public int modify(Integer storeId, Integer id,
			  		String name, Integer sort) {
		CategoryDao categoryDao = gemsShopSqlSessionTemplate.getMapper(CategoryDao.class);
		return categoryDao.modify(storeId, id, name, sort);
	}
	
}

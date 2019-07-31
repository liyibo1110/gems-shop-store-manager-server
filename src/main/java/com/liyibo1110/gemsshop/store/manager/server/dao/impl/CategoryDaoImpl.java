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
		CategoryDao dao = gemsShopSqlSessionTemplate.getMapper(CategoryDao.class);
		return dao.getList(storeId, name, limit, offset);
	}
	
	public List<Category> getAll(Integer storeId){
		CategoryDao dao = gemsShopSqlSessionTemplate.getMapper(CategoryDao.class);
		return dao.getAll(storeId);
	}

	public int getCount(Integer storeId, String name) {
		CategoryDao dao = gemsShopSqlSessionTemplate.getMapper(CategoryDao.class);
		return dao.getCount(storeId, name);
	}
	
	public int create(Integer storeId, String name,
			 		Integer sort) {
		CategoryDao dao = gemsShopSqlSessionTemplate.getMapper(CategoryDao.class);
		return dao.create(storeId, name, sort);
	}

	public int modify(Integer storeId, Integer id,
			  		String name, Integer sort) {
		CategoryDao dao = gemsShopSqlSessionTemplate.getMapper(CategoryDao.class);
		return dao.modify(storeId, id, name, sort);
	}
	
}

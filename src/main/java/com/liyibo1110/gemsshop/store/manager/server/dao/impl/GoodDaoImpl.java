package com.liyibo1110.gemsshop.store.manager.server.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.liyibo1110.gemsshop.store.manager.server.dao.AbstractDao;
import com.liyibo1110.gemsshop.store.manager.server.dao.GoodDao;
import com.liyibo1110.gemsshop.store.manager.server.entity.Good;

/**
 * 
 * @author liyibo
 *
 */
@Repository
public class GoodDaoImpl extends AbstractDao implements GoodDao{

	private static Logger logger = LoggerFactory.getLogger(GoodDaoImpl.class);
	
	@Override
	public List<Good> getList(Integer storeId, String name, 
								Integer limit, Integer offset){
		GoodDao goodDao = gemsShopSqlSessionTemplate.getMapper(GoodDao.class);
		return goodDao.getList(storeId, name, limit, offset);
	}

	@Override
	public int getCount(Integer storeId, String name) {
		GoodDao goodDao = gemsShopSqlSessionTemplate.getMapper(GoodDao.class);
		return goodDao.getCount(storeId, name);
	}
	
	@Override
	public Good getById(Integer id, Integer storeId) {
		GoodDao goodDao = gemsShopSqlSessionTemplate.getMapper(GoodDao.class);
		return goodDao.getById(id, storeId);
	}
	
	@Override
	public int create(Good good) {
		GoodDao goodDao = gemsShopSqlSessionTemplate.getMapper(GoodDao.class);
		return goodDao.create(good);
	}

	@Override
	public int modify(Integer storeId, Integer id,
			  String name, Integer categoryId,
			  Integer specType, Integer deductStockType,
			  String content, Integer salesInitial,
			  Integer sort,
			  Integer deliveryId, Integer status) {
		GoodDao goodDao = gemsShopSqlSessionTemplate.getMapper(GoodDao.class);
		return goodDao.modify(storeId, id, name, categoryId, specType, 
							deductStockType, content, salesInitial, sort, 
							deliveryId, status);
	}
	
}

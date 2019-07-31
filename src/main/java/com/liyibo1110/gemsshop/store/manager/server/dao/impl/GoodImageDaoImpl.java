package com.liyibo1110.gemsshop.store.manager.server.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.liyibo1110.gemsshop.store.manager.server.dao.AbstractDao;
import com.liyibo1110.gemsshop.store.manager.server.dao.GoodImageDao;

/**
 * 
 * @author liyibo
 *
 */
@Repository
public class GoodImageDaoImpl extends AbstractDao implements GoodImageDao{

	private static Logger logger = LoggerFactory.getLogger(GoodImageDaoImpl.class);
	
	public int create(Integer storeId, Integer goodId,
			  		Integer imageId) {
		GoodImageDao dao = gemsShopSqlSessionTemplate.getMapper(GoodImageDao.class);
		return dao.create(storeId, goodId, imageId);
	}
	
	public int deleteByGoodId(Integer storeId, Integer goodId) {
		GoodImageDao dao = gemsShopSqlSessionTemplate.getMapper(GoodImageDao.class);
		return dao.deleteByGoodId(storeId, goodId);
	}
}

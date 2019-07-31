package com.liyibo1110.gemsshop.store.manager.server.dao.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.liyibo1110.gemsshop.store.manager.server.dao.AbstractDao;
import com.liyibo1110.gemsshop.store.manager.server.dao.GoodSpecDao;

/**
 * 
 * @author liyibo
 *
 */
@Repository
public class GoodSpecDaoImpl extends AbstractDao implements GoodSpecDao{

	private static Logger logger = LoggerFactory.getLogger(GoodSpecDaoImpl.class);
	
	@Override
	public int create(Integer storeId, Integer goodId,
			  		String no, BigDecimal price,
			  		BigDecimal linePrice, Integer stockNum,
			  		BigDecimal weight) {
		GoodSpecDao dao = gemsShopSqlSessionTemplate.getMapper(GoodSpecDao.class);
		return dao.create(storeId, goodId, no, price, linePrice, 
								stockNum, weight);
	}

	@Override
	public int modify(Integer storeId, Integer goodId,
			  		String no, BigDecimal price,
			  		BigDecimal linePrice, Integer stockNum,
			  		BigDecimal weight) {
		GoodSpecDao dao = gemsShopSqlSessionTemplate.getMapper(GoodSpecDao.class);
		return dao.modify(storeId, goodId, no, price, linePrice, 
							stockNum, weight);
	}
	
}

package com.liyibo1110.gemsshop.store.manager.server.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.liyibo1110.gemsshop.store.manager.server.dao.AbstractDao;
import com.liyibo1110.gemsshop.store.manager.server.dao.OrderGoodDao;
import com.liyibo1110.gemsshop.store.manager.server.entity.OrderGood;

/**
 * 
 * @author liyibo
 *
 */
@Repository
public class OrderGoodDaoImpl extends AbstractDao implements OrderGoodDao{

	private static Logger logger = LoggerFactory.getLogger(OrderGoodDaoImpl.class);
	
	@Override
	public List<OrderGood> getList(Integer storeId, Integer orderId){
		OrderGoodDao dao = gemsShopSqlSessionTemplate.getMapper(OrderGoodDao.class);
		return dao.getList(storeId, orderId);
	}
	
}

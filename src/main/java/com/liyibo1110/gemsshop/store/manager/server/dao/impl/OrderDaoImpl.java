package com.liyibo1110.gemsshop.store.manager.server.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.liyibo1110.gemsshop.store.manager.server.dao.AbstractDao;
import com.liyibo1110.gemsshop.store.manager.server.dao.OrderDao;
import com.liyibo1110.gemsshop.store.manager.server.entity.Order;

/**
 * 
 * @author liyibo
 *
 */
@Repository
public class OrderDaoImpl extends AbstractDao implements OrderDao{

	private static Logger logger = LoggerFactory.getLogger(OrderDaoImpl.class);
	
	@Override
	public List<Order> getList(Integer storeId, Integer payStatus,
							   Integer deliveryStatus, Integer receiptStatus,
								Integer limit, Integer offset){
		OrderDao dao = gemsShopSqlSessionTemplate.getMapper(OrderDao.class);
		return dao.getList(storeId, payStatus, deliveryStatus, receiptStatus, limit, offset);
	}

	@Override
	public int getCount(Integer storeId, Integer payStatus,
			   Integer deliveryStatus, Integer receiptStatus) {
		OrderDao dao = gemsShopSqlSessionTemplate.getMapper(OrderDao.class);
		return dao.getCount(storeId, payStatus, deliveryStatus, receiptStatus);
	}
	
}

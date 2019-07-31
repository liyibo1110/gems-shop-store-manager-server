package com.liyibo1110.gemsshop.store.manager.server.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.liyibo1110.gemsshop.store.manager.server.dao.AbstractDao;
import com.liyibo1110.gemsshop.store.manager.server.dao.OrderAddressDao;
import com.liyibo1110.gemsshop.store.manager.server.entity.OrderAddress;

/**
 * 
 * @author liyibo
 *
 */
@Repository
public class OrderAddressDaoImpl extends AbstractDao implements OrderAddressDao{

	private static Logger logger = LoggerFactory.getLogger(OrderAddressDaoImpl.class);
	
	@Override
	public OrderAddress getByOrderId(Integer storeId, Integer orderId){
		OrderAddressDao dao = gemsShopSqlSessionTemplate.getMapper(OrderAddressDao.class);
		return dao.getByOrderId(storeId, orderId);
	}
	
}

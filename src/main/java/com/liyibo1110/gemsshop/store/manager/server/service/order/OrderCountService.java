package com.liyibo1110.gemsshop.store.manager.server.service.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;

@Service
public class OrderCountService extends BaseOrderService{

	private static Logger logger = LoggerFactory.getLogger(OrderCountService.class);
	
	public Integer count(StoreUser user, Integer payStatus, 
			Integer deliveryStatus, Integer receiptStatus){
		
		return orderDao.getCount(user.getStoreId(), payStatus, deliveryStatus, receiptStatus);
	}
}

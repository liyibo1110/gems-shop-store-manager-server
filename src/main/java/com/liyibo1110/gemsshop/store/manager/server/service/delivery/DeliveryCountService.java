package com.liyibo1110.gemsshop.store.manager.server.service.delivery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;

@Service
public class DeliveryCountService extends BaseDeliveryService{

	private static Logger logger = LoggerFactory.getLogger(DeliveryCountService.class);
	
	public Integer count(StoreUser user, String name){
		
		Integer count = deliveryDao.getCount(user.getStoreId(), name);
		if(count == null) {
			return 0;
		}else {
			return count;
		}
	}
}

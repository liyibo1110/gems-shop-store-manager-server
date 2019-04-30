package com.liyibo1110.gemsshop.store.manager.server.service.delivery;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.Delivery;
import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;

@Service
public class DeliveryAllService extends BaseDeliveryService{

	private static Logger logger = LoggerFactory.getLogger(DeliveryAllService.class);
	
	public List<Delivery> all(StoreUser user){
	
		return deliveryDao.getAll(user.getStoreId());
	}
}

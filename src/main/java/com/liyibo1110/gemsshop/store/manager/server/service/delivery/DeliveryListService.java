package com.liyibo1110.gemsshop.store.manager.server.service.delivery;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.Delivery;
import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;

@Service
public class DeliveryListService extends BaseDeliveryService{

	private static Logger logger = LoggerFactory.getLogger(DeliveryListService.class);
	
	public List<Delivery> list(StoreUser user, String name, 
							Integer limit, Integer offset){
	
		return deliveryDao.getList(user.getStoreId(), name, limit, offset);
	}
}

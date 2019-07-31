package com.liyibo1110.gemsshop.store.manager.server.service.delivery;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.Delivery;
import com.liyibo1110.gemsshop.store.manager.server.entity.DeliveryRule;
import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;

@Service
public class DeliveryGetByIdService extends BaseDeliveryService{

	private static Logger logger = LoggerFactory.getLogger(DeliveryGetByIdService.class);
	
	public Delivery get(StoreUser user, Integer id){
	
		Delivery delivery = deliveryDao.getById(id, user.getStoreId());
		List<DeliveryRule> ruleList = deliveryDao.getByDeliveryId(id, user.getStoreId());
		delivery.setRules(ruleList);
		return delivery;
	}
}

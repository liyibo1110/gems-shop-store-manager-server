package com.liyibo1110.gemsshop.store.manager.server.service.delivery;

import org.springframework.beans.factory.annotation.Autowired;

import com.liyibo1110.gemsshop.store.manager.server.dao.DeliveryDao;
import com.liyibo1110.gemsshop.store.manager.server.service.BaseService;

public class BaseDeliveryService extends BaseService{

	@Autowired
	protected DeliveryDao deliveryDao;
}

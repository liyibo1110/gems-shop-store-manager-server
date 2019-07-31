package com.liyibo1110.gemsshop.store.manager.server.service.order;

import org.springframework.beans.factory.annotation.Autowired;

import com.liyibo1110.gemsshop.store.manager.server.dao.OrderAddressDao;
import com.liyibo1110.gemsshop.store.manager.server.dao.OrderDao;
import com.liyibo1110.gemsshop.store.manager.server.dao.OrderGoodDao;
import com.liyibo1110.gemsshop.store.manager.server.service.BaseService;

public class BaseOrderService extends BaseService{

	@Autowired
	protected OrderDao orderDao;

	@Autowired
	protected OrderGoodDao orderGoodDao;
	
	@Autowired
	protected OrderAddressDao orderAddressDao;
}

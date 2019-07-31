package com.liyibo1110.gemsshop.store.manager.server.service.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;

/**
 * 
 * @author liyibo
 *
 */
@Service
public class OrderModifyDeliveryStatusService extends BaseOrderService{

	private static Logger logger = LoggerFactory.getLogger(OrderModifyDeliveryStatusService.class);
	
	public int modify(StoreUser user, Integer id, 
					String companyName, String no){  
		
		return orderDao.modifyDeliveryStatus(user.getStoreId(), id, companyName, no);
	}
}

package com.liyibo1110.gemsshop.store.manager.server.service.good;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;

@Service
public class GoodCountService extends BaseGoodService{

	private static Logger logger = LoggerFactory.getLogger(GoodCountService.class);
	
	public Integer count(StoreUser user, String name){
		
		return goodDao.getCount(user.getStoreId(), name);
	}
}

package com.liyibo1110.gemsshop.store.manager.server.service.storeuser;

import org.springframework.beans.factory.annotation.Autowired;

import com.liyibo1110.gemsshop.store.manager.server.dao.StoreUserDao;
import com.liyibo1110.gemsshop.store.manager.server.service.BaseService;

public class BaseStoreUserService extends BaseService{

	@Autowired
	protected StoreUserDao storeUserDao;
}

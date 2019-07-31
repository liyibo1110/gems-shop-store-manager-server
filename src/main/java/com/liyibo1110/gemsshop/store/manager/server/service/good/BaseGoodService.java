package com.liyibo1110.gemsshop.store.manager.server.service.good;

import org.springframework.beans.factory.annotation.Autowired;

import com.liyibo1110.gemsshop.store.manager.server.dao.GoodDao;
import com.liyibo1110.gemsshop.store.manager.server.dao.GoodImageDao;
import com.liyibo1110.gemsshop.store.manager.server.dao.GoodSpecDao;
import com.liyibo1110.gemsshop.store.manager.server.dao.UploadFileDao;
import com.liyibo1110.gemsshop.store.manager.server.service.BaseService;

public class BaseGoodService extends BaseService{

	@Autowired
	protected GoodDao goodDao;
	
	@Autowired
	protected GoodSpecDao goodSpecDao;
	
	@Autowired
	protected GoodImageDao goodImageDao;
	
	@Autowired
	protected UploadFileDao uploadFileDao;
}

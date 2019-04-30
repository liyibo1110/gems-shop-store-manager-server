package com.liyibo1110.gemsshop.store.manager.server.service.uploadgroup;

import org.springframework.beans.factory.annotation.Autowired;

import com.liyibo1110.gemsshop.store.manager.server.dao.UploadGroupDao;
import com.liyibo1110.gemsshop.store.manager.server.service.BaseService;

public class BaseUploadGroupService extends BaseService{

	@Autowired
	protected UploadGroupDao uploadGroupDao;
}

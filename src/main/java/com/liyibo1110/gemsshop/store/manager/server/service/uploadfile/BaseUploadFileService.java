package com.liyibo1110.gemsshop.store.manager.server.service.uploadfile;

import org.springframework.beans.factory.annotation.Autowired;

import com.liyibo1110.gemsshop.store.manager.server.dao.UploadFileDao;
import com.liyibo1110.gemsshop.store.manager.server.service.BaseService;

public class BaseUploadFileService extends BaseService{

	@Autowired
	protected UploadFileDao uploadFileDao;
}

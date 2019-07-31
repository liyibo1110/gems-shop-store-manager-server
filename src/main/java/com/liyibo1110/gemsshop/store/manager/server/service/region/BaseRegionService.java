package com.liyibo1110.gemsshop.store.manager.server.service.region;

import org.springframework.beans.factory.annotation.Autowired;

import com.liyibo1110.gemsshop.store.manager.server.dao.RegionDao;
import com.liyibo1110.gemsshop.store.manager.server.service.BaseService;

/**
 * 
 * @author liyibo
 *
 */
public class BaseRegionService extends BaseService{

	@Autowired
	protected RegionDao regionDao;
}

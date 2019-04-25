package com.liyibo1110.gemsshop.store.manager.server.service.region;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.Region;

/**
 * 
 * @author liyibo
 *
 */
@Service
public class RegionAllCityService extends BaseRegionService{

	private static Logger logger = LoggerFactory.getLogger(RegionAllCityService.class);
	
	public List<Region> all(){
	
		return regionDao.getAllCity();
	}
}

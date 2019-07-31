package com.liyibo1110.gemsshop.store.manager.server.dao;

import java.util.List;

import com.liyibo1110.gemsshop.store.manager.server.entity.Region;

/**
 * 
 * @author liyibo
 *
 */
public interface RegionDao {
	
	public List<Region> getAllProvince();	
	public List<Region> getAllCity();	
}

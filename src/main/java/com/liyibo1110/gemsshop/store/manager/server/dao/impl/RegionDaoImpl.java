package com.liyibo1110.gemsshop.store.manager.server.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.liyibo1110.gemsshop.store.manager.server.dao.AbstractDao;
import com.liyibo1110.gemsshop.store.manager.server.dao.RegionDao;
import com.liyibo1110.gemsshop.store.manager.server.entity.Region;

/**
 * 
 * @author liyibo
 *
 */
@Repository
public class RegionDaoImpl extends AbstractDao implements RegionDao{

	private static Logger logger = LoggerFactory.getLogger(RegionDaoImpl.class);
	
	public List<Region> getAllProvince(){
		RegionDao dao = gemsShopSqlSessionTemplate.getMapper(RegionDao.class);
		return dao.getAllProvince();
	}
	
	public List<Region> getAllCity(){
		RegionDao dao = gemsShopSqlSessionTemplate.getMapper(RegionDao.class);
		return dao.getAllCity();
	}
	
}

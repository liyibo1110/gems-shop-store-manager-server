package com.liyibo1110.gemsshop.store.manager.server.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.liyibo1110.gemsshop.store.manager.server.dao.AbstractDao;
import com.liyibo1110.gemsshop.store.manager.server.dao.UploadGroupDao;
import com.liyibo1110.gemsshop.store.manager.server.entity.UploadGroup;

/**
 * 
 * @author liyibo
 *
 */
@Repository
public class UploadGroupDaoImpl extends AbstractDao implements UploadGroupDao{

	private static Logger logger = LoggerFactory.getLogger(UploadGroupDaoImpl.class);
	
	public List<UploadGroup> getAll(Integer storeId){
		UploadGroupDao dao = gemsShopSqlSessionTemplate.getMapper(UploadGroupDao.class);
		return dao.getAll(storeId);
	}
	
	public int create(Integer storeId, Integer type,
					String name, Integer sort) {
		UploadGroupDao dao = gemsShopSqlSessionTemplate.getMapper(UploadGroupDao.class);
		return dao.create(storeId, type, name, sort);
	}

	public int modify(Integer storeId, Integer id,
			  		String name) {
		UploadGroupDao dao = gemsShopSqlSessionTemplate.getMapper(UploadGroupDao.class);
		return dao.modify(storeId, id, name);
	}
	
}

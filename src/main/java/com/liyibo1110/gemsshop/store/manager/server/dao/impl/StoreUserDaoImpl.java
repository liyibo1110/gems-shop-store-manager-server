package com.liyibo1110.gemsshop.store.manager.server.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.liyibo1110.gemsshop.store.manager.server.dao.AbstractDao;
import com.liyibo1110.gemsshop.store.manager.server.dao.StoreUserDao;
import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;

@Repository
public class StoreUserDaoImpl extends AbstractDao implements StoreUserDao{

	private static Logger logger = LoggerFactory.getLogger(StoreUserDaoImpl.class);
	
	public StoreUser getByUsername(String username) {
		StoreUserDao dao = gemsShopSqlSessionTemplate.getMapper(StoreUserDao.class);
		return dao.getByUsername(username);
	}
	
	public StoreUser getByToken(String token) {
		StoreUserDao dao = gemsShopSqlSessionTemplate.getMapper(StoreUserDao.class);
		return dao.getByToken(token);
	}
	
	public int updatePassword(Integer id, String password) {
		StoreUserDao dao = gemsShopSqlSessionTemplate.getMapper(StoreUserDao.class);
		return dao.updatePassword(id, password);
	}
}

package com.liyibo1110.gemsshop.store.manager.server.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractDao {

	@Autowired
	@Qualifier("gemsShopSqlSessionTemplate")
	protected SqlSessionTemplate gemsShopSqlSessionTemplate;
	
}

package com.liyibo1110.gemsshop.store.manager.server.dao;

import org.apache.ibatis.annotations.Param;

import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;

/**
 * 
 * @author liyibo
 *
 */
public interface StoreUserDao {
	
	public StoreUser getByUsername(@Param("username")String username);	
	
	public StoreUser getByToken(@Param("token")String token);	
	
	public int updatePassword(@Param("id")Integer id, 
							  @Param("password")String password);
}

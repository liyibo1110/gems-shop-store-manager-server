package com.liyibo1110.gemsshop.store.manager.server.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author liyibo
 *
 */
public interface GoodImageDao {
	
	public int create(@Param("storeId")Integer storeId, 
					  @Param("goodId")Integer goodId,
					  @Param("imageId")Integer imageId);	
	
	public int deleteByGoodId(@Param("storeId")Integer storeId, 
							  @Param("goodId")Integer goodId);
}

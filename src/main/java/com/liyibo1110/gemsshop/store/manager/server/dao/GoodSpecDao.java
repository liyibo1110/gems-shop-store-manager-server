package com.liyibo1110.gemsshop.store.manager.server.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author liyibo
 *
 */
public interface GoodSpecDao {
	
	public int create(@Param("storeId")Integer storeId, 
			  @Param("goodId")Integer goodId,
			  @Param("no")String no,
			  @Param("price")BigDecimal price,
			  @Param("linePrice")BigDecimal linePrice,
			  @Param("stockNum")Integer stockNum,
			  @Param("weight")BigDecimal weight);	
	
	public int modify(@Param("storeId")Integer storeId, 
					  @Param("goodId")Integer goodId,
					  @Param("no")String no,
					  @Param("price")BigDecimal price,
					  @Param("linePrice")BigDecimal linePrice,
					  @Param("stockNum")Integer stockNum,
					  @Param("weight")BigDecimal weight);	
}

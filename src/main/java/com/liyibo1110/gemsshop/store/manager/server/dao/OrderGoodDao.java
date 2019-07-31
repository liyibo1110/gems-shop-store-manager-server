package com.liyibo1110.gemsshop.store.manager.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liyibo1110.gemsshop.store.manager.server.entity.OrderGood;

/**
 * 
 * @author liyibo
 *
 */
public interface OrderGoodDao {
	
	public List<OrderGood> getList(@Param("storeId")Integer storeId, 
								   @Param("orderId")Integer orderId);	
	
}

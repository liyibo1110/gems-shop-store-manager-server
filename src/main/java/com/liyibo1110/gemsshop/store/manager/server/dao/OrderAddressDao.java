package com.liyibo1110.gemsshop.store.manager.server.dao;

import org.apache.ibatis.annotations.Param;

import com.liyibo1110.gemsshop.store.manager.server.entity.OrderAddress;

/**
 * 
 * @author liyibo
 *
 */
public interface OrderAddressDao {
	
	public OrderAddress getByOrderId(@Param("storeId")Integer storeId, 
									 @Param("orderId")Integer orderId);	
	
}

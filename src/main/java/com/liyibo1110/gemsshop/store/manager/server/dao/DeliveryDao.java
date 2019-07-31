package com.liyibo1110.gemsshop.store.manager.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liyibo1110.gemsshop.store.manager.server.entity.Delivery;
import com.liyibo1110.gemsshop.store.manager.server.entity.DeliveryRule;

/**
 * 
 * @author liyibo
 *
 */
public interface DeliveryDao {
	
	public List<Delivery> getAll(@Param("storeId")Integer storeId);
	
	public List<Delivery> getList(@Param("storeId")Integer storeId, 
								@Param("name")String name, 
								@Param("limit")Integer limit,
								@Param("offset")Integer offset);	
	
	public int getCount(@Param("storeId")Integer storeId, 
		    			@Param("name")String name);	
	
	public Delivery getById(@Param("id")Integer id, @Param("storeId")Integer storeId);	
	
	public int create(@Param("delivery")Delivery delivery);	
	
	public int modify(@Param("storeId")Integer storeId, 
			  @Param("id")Integer id,
			  @Param("name")String name,
			  @Param("method")Integer method,
			  @Param("sort")Integer sort);
	
	public int createRule(@Param("deliveryId")Integer deliveryId,
						@Param("region")String region,
						@Param("first")Integer first,
						@Param("firstFee")Double firstFee,
						@Param("additional")Integer additional,
						@Param("additionalFee")Double additionalFee,
						@Param("storeId")Integer storeId);	
	
	public List<DeliveryRule> getByDeliveryId(@Param("deliveryId")Integer deliveryId, @Param("storeId")Integer storeId);
	
	public int deleteByDeliveryId(@Param("deliveryId")Integer deliveryId, @Param("storeId")Integer storeId);
	
	
}

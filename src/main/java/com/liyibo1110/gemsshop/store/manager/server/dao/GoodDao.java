package com.liyibo1110.gemsshop.store.manager.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liyibo1110.gemsshop.store.manager.server.entity.Delivery;
import com.liyibo1110.gemsshop.store.manager.server.entity.DeliveryRule;
import com.liyibo1110.gemsshop.store.manager.server.entity.Good;

/**
 * 
 * @author liyibo
 *
 */
public interface GoodDao {
	
	public List<Good> getList(@Param("storeId")Integer storeId, 
								@Param("name")String name, 
								@Param("limit")Integer limit,
								@Param("offset")Integer offset);	
	
	public int getCount(@Param("storeId")Integer storeId, 
		    				@Param("name")String name);	
	
	public Good getById(@Param("id")Integer id, @Param("storeId")Integer storeId);
	
	public int create(@Param("good")Good good);	
	
	public int modify(@Param("storeId")Integer storeId, 
					  @Param("id")Integer id,
					  @Param("name")String name,
					  @Param("categoryId")Integer categoryId,
					  @Param("specType")Integer specType,
					  @Param("deductStockType")Integer deductStockType,
					  @Param("content")String content,
					  @Param("salesInitial")Integer salesInitial,
					  @Param("sort")Integer sort,
					  @Param("deliveryId")Integer deliveryId,
					  @Param("status")Integer status);	
}

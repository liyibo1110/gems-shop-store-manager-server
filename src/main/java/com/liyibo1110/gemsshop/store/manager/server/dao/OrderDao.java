package com.liyibo1110.gemsshop.store.manager.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liyibo1110.gemsshop.store.manager.server.entity.Order;

/**
 * 
 * @author liyibo
 *
 */
public interface OrderDao {
	
	public List<Order> getList(@Param("storeId")Integer storeId, 
								@Param("payStatus")Integer payStatus, 
								@Param("deliveryStatus")Integer deliveryStatus, 
								@Param("receiptStatus")Integer receiptStatus, 
								@Param("limit")Integer limit,
								@Param("offset")Integer offset);	
	
	public int getCount(@Param("storeId")Integer storeId, 
						@Param("payStatus")Integer payStatus, 
						@Param("deliveryStatus")Integer deliveryStatus, 
						@Param("receiptStatus")Integer receiptStatus);	
	
	public Order getById(@Param("storeId")Integer storeId, 
			 			 @Param("id")Integer id);
	
	public int modifyDeliveryStatus(@Param("storeId")Integer storeId, 
									@Param("id")Integer id, 
			 						@Param("companyName")String companyName,
			 						@Param("no")String no);
	
}

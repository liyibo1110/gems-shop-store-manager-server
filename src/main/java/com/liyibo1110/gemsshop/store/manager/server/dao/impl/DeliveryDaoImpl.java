package com.liyibo1110.gemsshop.store.manager.server.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.liyibo1110.gemsshop.store.manager.server.dao.AbstractDao;
import com.liyibo1110.gemsshop.store.manager.server.dao.DeliveryDao;
import com.liyibo1110.gemsshop.store.manager.server.entity.Delivery;
import com.liyibo1110.gemsshop.store.manager.server.entity.DeliveryRule;

/**
 * 
 * @author liyibo
 *
 */
@Repository
public class DeliveryDaoImpl extends AbstractDao implements DeliveryDao{

	private static Logger logger = LoggerFactory.getLogger(DeliveryDaoImpl.class);
	
	public List<Delivery> getList(Integer storeId, String name, 
								Integer limit, Integer offset){
		DeliveryDao deliveryDao = gemsShopSqlSessionTemplate.getMapper(DeliveryDao.class);
		return deliveryDao.getList(storeId, name, limit, offset);
	}

	public int getCount(Integer storeId, String name) {
		DeliveryDao deliveryDao = gemsShopSqlSessionTemplate.getMapper(DeliveryDao.class);
		return deliveryDao.getCount(storeId, name);
	}
	
	public Delivery getById(Integer id, Integer storeId) {
		DeliveryDao deliveryDao = gemsShopSqlSessionTemplate.getMapper(DeliveryDao.class);
		return deliveryDao.getById(id, storeId);
	}
	
	public int create(Delivery delivery) {
		DeliveryDao deliveryDao = gemsShopSqlSessionTemplate.getMapper(DeliveryDao.class);
		return deliveryDao.create(delivery);
	}
	
	public int modify(Integer storeId, Integer id,
			  		String name, Integer method,
			  		Integer sort) {
		DeliveryDao deliveryDao = gemsShopSqlSessionTemplate.getMapper(DeliveryDao.class);
		return deliveryDao.modify(storeId, id, name, method, sort);
	}
	
	public int createRule(Integer deliveryId, String region,
						Integer first, Double firstFee,
						Integer additional, Double additionalFee,
						Integer storeId) {
		DeliveryDao deliveryDao = gemsShopSqlSessionTemplate.getMapper(DeliveryDao.class);
		return deliveryDao.createRule(deliveryId, region, first, firstFee, additional, additionalFee, storeId);
	}
	
	public List<DeliveryRule> getByDeliveryId(Integer deliveryId, Integer storeId) {
		DeliveryDao deliveryDao = gemsShopSqlSessionTemplate.getMapper(DeliveryDao.class);
		return deliveryDao.getByDeliveryId(deliveryId, storeId);
	}
	
	public int deleteByDeliveryId(Integer deliveryId, Integer storeId) {
		DeliveryDao deliveryDao = gemsShopSqlSessionTemplate.getMapper(DeliveryDao.class);
		return deliveryDao.deleteByDeliveryId(deliveryId, storeId);
	}
	
}

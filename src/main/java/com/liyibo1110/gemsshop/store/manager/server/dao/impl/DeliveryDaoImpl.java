package com.liyibo1110.gemsshop.store.manager.server.dao.impl;

import java.util.List;

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
	
	public List<Delivery> getAll(Integer storeId){
		DeliveryDao dao = gemsShopSqlSessionTemplate.getMapper(DeliveryDao.class);
		return dao.getAll(storeId);
	}
	
	public List<Delivery> getList(Integer storeId, String name, 
								Integer limit, Integer offset){
		DeliveryDao dao = gemsShopSqlSessionTemplate.getMapper(DeliveryDao.class);
		return dao.getList(storeId, name, limit, offset);
	}

	public int getCount(Integer storeId, String name) {
		DeliveryDao dao = gemsShopSqlSessionTemplate.getMapper(DeliveryDao.class);
		return dao.getCount(storeId, name);
	}
	
	public Delivery getById(Integer id, Integer storeId) {
		DeliveryDao dao = gemsShopSqlSessionTemplate.getMapper(DeliveryDao.class);
		return dao.getById(id, storeId);
	}
	
	public int create(Delivery delivery) {
		DeliveryDao dao = gemsShopSqlSessionTemplate.getMapper(DeliveryDao.class);
		return dao.create(delivery);
	}
	
	public int modify(Integer storeId, Integer id,
			  		String name, Integer method,
			  		Integer sort) {
		DeliveryDao dao = gemsShopSqlSessionTemplate.getMapper(DeliveryDao.class);
		return dao.modify(storeId, id, name, method, sort);
	}
	
	public int createRule(Integer deliveryId, String region,
						Integer first, Double firstFee,
						Integer additional, Double additionalFee,
						Integer storeId) {
		DeliveryDao dao = gemsShopSqlSessionTemplate.getMapper(DeliveryDao.class);
		return dao.createRule(deliveryId, region, first, firstFee, additional, additionalFee, storeId);
	}
	
	public List<DeliveryRule> getByDeliveryId(Integer deliveryId, Integer storeId) {
		DeliveryDao dao = gemsShopSqlSessionTemplate.getMapper(DeliveryDao.class);
		return dao.getByDeliveryId(deliveryId, storeId);
	}
	
	public int deleteByDeliveryId(Integer deliveryId, Integer storeId) {
		DeliveryDao dao = gemsShopSqlSessionTemplate.getMapper(DeliveryDao.class);
		return dao.deleteByDeliveryId(deliveryId, storeId);
	}
	
}

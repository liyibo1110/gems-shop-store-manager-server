package com.liyibo1110.gemsshop.store.manager.server.service.delivery;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.Delivery;
import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;
import com.liyibo1110.gemsshop.store.manager.server.util.ListUtils;
import com.liyibo1110.gemsshop.store.manager.server.vo.DeliveryRuleVO;

/**
 * 
 * @author liyibo
 *
 */
@Service
public class DeliveryCreateService extends BaseDeliveryService{

	private static Logger logger = LoggerFactory.getLogger(DeliveryCreateService.class);
	
	public int create(StoreUser user, String name, Integer method, Integer sort, List<DeliveryRuleVO> ruleList){  
		
		//先插入主体，获取主键
		Delivery d = new Delivery();
		d.setName(name);
		d.setMethod(method);
		d.setSort(sort);
		d.setStoreId(user.getStoreId());
		int result = deliveryDao.create(d);
		//logger.info("生成的id为：" + d.getId());
		//再插入rule
		for(DeliveryRuleVO rule : ruleList) {
			String regionStr = ListUtils.integerListToString(rule.getRegion());
			deliveryDao.createRule(d.getId(), regionStr, rule.getFirst(), rule.getFirstFee(), rule.getAdditional(), 
								rule.getAdditionalFee(), user.getStoreId());
		}
		return result;
	}
}

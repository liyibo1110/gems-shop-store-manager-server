package com.liyibo1110.gemsshop.store.manager.server.service.delivery;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;
import com.liyibo1110.gemsshop.store.manager.server.util.ListUtils;
import com.liyibo1110.gemsshop.store.manager.server.vo.DeliveryRuleVO;

/**
 * 
 * @author liyibo
 *
 */
@Service
public class DeliveryModifyService extends BaseDeliveryService{

	private static Logger logger = LoggerFactory.getLogger(DeliveryModifyService.class);
	
	public int modify(StoreUser user, Integer id, String name, Integer method, Integer sort, List<DeliveryRuleVO> ruleList){  
		
		//先修改主体
		int result = deliveryDao.modify(user.getStoreId(), id, name, method, sort);
		//再删除所有rule
		deliveryDao.deleteByDeliveryId(id, user.getStoreId());
		//再重新插入所有rule
		for(DeliveryRuleVO rule : ruleList) {
			String regionStr = ListUtils.integerListToString(rule.getRegion());
			deliveryDao.createRule(id, regionStr, rule.getFirst(), rule.getFirstFee(), rule.getAdditional(), 
								rule.getAdditionalFee(), user.getStoreId());
		}
		return result;
	}
}

package com.liyibo1110.gemsshop.store.manager.server.service.good;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;

/**
 * 
 * @author liyibo
 *
 */
@Service
public class GoodModifyService extends BaseGoodService{

	private static Logger logger = LoggerFactory.getLogger(GoodModifyService.class);
	
	public int modify(StoreUser user, Integer id, 
					String name, Integer categoryId, 
					String imageIds, Integer specType, 
					String no, BigDecimal price, 
					BigDecimal linePrice, Integer stockNum, 
					BigDecimal weight, Integer deductStockType, 
					String content, Integer deliveryId, 
					Integer status, Integer salesInitial, 
					Integer sort){  
		
		//先修改本体
		int result = goodDao.modify(user.getStoreId(), id, name, categoryId, specType, 
					deductStockType, content, salesInitial, sort,
					deliveryId, status);
		//再修改单规格
		goodSpecDao.modify(user.getStoreId(), id, no, price, linePrice, stockNum, weight);
		//再修改图片（先清空再新增）
		goodImageDao.deleteByGoodId(user.getStoreId(), id);
		if(StringUtils.isNotBlank(imageIds)) {	//按规则是必有imageIds的
			String[] imageIdsArray = StringUtils.split(imageIds, ",");
			for(String imageIdStr : imageIdsArray) {
				int imageId = Integer.parseInt(imageIdStr);
				goodImageDao.create(user.getStoreId(), id, imageId);
			}
		}
		return result;
	}
}

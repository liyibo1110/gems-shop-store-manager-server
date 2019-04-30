package com.liyibo1110.gemsshop.store.manager.server.service.good;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.Good;
import com.liyibo1110.gemsshop.store.manager.server.entity.GoodSpec;
import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;

/**
 * 
 * @author liyibo
 *
 */
@Service
public class GoodCreateService extends BaseGoodService{

	private static Logger logger = LoggerFactory.getLogger(GoodCreateService.class);
	
	public int create(StoreUser user, String name, Integer categoryId, 
					String imageIds, Integer specType, 
					String no, BigDecimal price, 
					BigDecimal linePrice, Integer stockNum, 
					BigDecimal weight, Integer deductStockType,
					String content, 
					Integer deliveryId, Integer status, 
					Integer salesInitial, Integer sort){  
		//先新增商品本身，并返回主键
		Good g = new Good();
		g.setName(name);
		g.setCategoryId(categoryId);
		g.setSpecType(10);	//写死
		g.setDeductStockType(deductStockType);
		g.setContent(content);
		g.setSalesInitial(salesInitial);
		g.setSort(sort);
		g.setDeliveryId(deliveryId);
		g.setStatus(status);
		g.setStoreId(user.getStoreId());
		int result = goodDao.create(g);
		int goodId = g.getId();
		//再新增规格信息，目前版本只有单规格
		GoodSpec gs = new GoodSpec();
		gs.setGoodId(goodId);
		gs.setNo(no);
		gs.setPrice(price);
		gs.setLinePrice(linePrice);
		gs.setStockNum(stockNum);
		gs.setWeight(weight);
		gs.setStoreId(user.getStoreId());
		goodSpecDao.create(user.getStoreId(), goodId, no, price, linePrice, stockNum, weight);
		//最后新增图片关联（图片本身已存好了）
		if(StringUtils.isNotBlank(imageIds)) {	//按规则是必有imageIds的
			String[] imageIdsArray = StringUtils.split(imageIds, ",");
			for(String imageIdStr : imageIdsArray) {
				int imageId = Integer.parseInt(imageIdStr);
				goodImageDao.create(user.getStoreId(), goodId, imageId);
			}
		}
		return result;
	}
}

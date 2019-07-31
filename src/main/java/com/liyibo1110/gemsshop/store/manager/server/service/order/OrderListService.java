package com.liyibo1110.gemsshop.store.manager.server.service.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.Good;
import com.liyibo1110.gemsshop.store.manager.server.entity.Order;
import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;
import com.liyibo1110.gemsshop.store.manager.server.entity.UploadFile;

@Service
public class OrderListService extends BaseOrderService{

	private static Logger logger = LoggerFactory.getLogger(OrderListService.class);
	
	public List<Order> list(StoreUser user, Integer payStatus, 
							Integer deliveryStatus, Integer receiptStatus, 
							Integer limit, Integer offset){
	
		List<Order> list = orderDao.getList(user.getStoreId(), payStatus, deliveryStatus, receiptStatus, limit, offset);
		for(Order o : list) {
			String goodsIdStr = o.getGoodsIdStr();
			String goodsNameStr = o.getGoodsNameStr();
			String goodsPriceStr = o.getGoodsPriceStr();
			String goodsTotalNumStr = o.getGoodsTotalNumStr();
			String storageStr = o.getStorageStr();
			String fileUrlStr = o.getFileUrlStr();
			String fileNameStr = o.getFileNameStr();
			String extensionStr = o.getExtensionStr();
			//假定订单至少有1个产品，每个产品至少有1个图片，并且每个产品只有1个图片
			if(StringUtils.isBlank(goodsIdStr)) continue;
			String[] goodsIds = StringUtils.split(goodsIdStr, ",");
			String[] goodsNames = StringUtils.split(goodsNameStr, ",");
			String[] goodsPrices = StringUtils.split(goodsPriceStr, ",");
			String[] goodsTotalNums = StringUtils.split(goodsTotalNumStr, ",");
			String[] storages = StringUtils.split(storageStr, ",");
			String[] fileUrls = StringUtils.split(fileUrlStr, ",");
			String[] fileNames = StringUtils.split(fileNameStr, ",");
			String[] extensions = StringUtils.split(extensionStr, ",");
			//logger.info("storages.size:" + storages.length);
			//生成产品和图片对象集合
			List<Good> goodList = new ArrayList<>();
			List<UploadFile> fileList = new ArrayList<>();
			for(int i=0; i<goodsIds.length; i++) {
				Good good = new Good();
				good.setId(Integer.parseInt(goodsIds[i]));
				good.setName(goodsNames[i]);
				good.setPrice(new BigDecimal(goodsPrices[i]));
				good.setTotalNum(Integer.parseInt(goodsTotalNums[i]));
				UploadFile file = new UploadFile();
				file.setStorage(Integer.parseInt(storages[i]));
				file.setGoodsId(Integer.parseInt(goodsIds[i]));
				file.setGoodsName(goodsNames[i]);
				if(fileUrls.length != 0) {
					file.setFileUrl(fileUrls[i]);
				}
				if(fileNames.length != 0) {
					file.setFileName(fileNames[i]);
				}
				if(extensions.length != 0) {
					file.setExtension(extensions[i]);
				}
				goodList.add(good);
				fileList.add(file);
			}
			o.setGoodList(goodList);
			o.setFileList(fileList);
		}
		return list;
	}
}

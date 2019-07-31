package com.liyibo1110.gemsshop.store.manager.server.service.order;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.dto.OrderDTO;
import com.liyibo1110.gemsshop.store.manager.server.entity.Order;
import com.liyibo1110.gemsshop.store.manager.server.entity.OrderAddress;
import com.liyibo1110.gemsshop.store.manager.server.entity.OrderGood;
import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;
import com.liyibo1110.gemsshop.store.manager.server.entity.UploadFile;

@Service
public class OrderGetByIdService extends BaseOrderService{

	private static Logger logger = LoggerFactory.getLogger(OrderGetByIdService.class);
	
	public OrderDTO get(StoreUser user, Integer id){
	
		Order order = orderDao.getById(user.getStoreId(), id);
		List<OrderGood> goods = orderGoodDao.getList(user.getStoreId(), id);
		OrderAddress orderAddress = orderAddressDao.getByOrderId(user.getStoreId(), id);
		
		for(OrderGood og : goods) {
			String storageStr = og.getStorageStr();
			String fileUrlStr = og.getFileUrlStr();
			String fileNameStr = og.getFileNameStr();
			String extensionStr = og.getExtensionStr();
			//假定每个产品至少有1个图片，并且每个产品只有1个图片
			if(StringUtils.isBlank(storageStr)) continue;
			String[] storages = StringUtils.split(storageStr, ",");
			String[] fileUrls = StringUtils.split(fileUrlStr, ",");
			String[] fileNames = StringUtils.split(fileNameStr, ",");
			String[] extensions = StringUtils.split(extensionStr, ",");
		
			UploadFile file = new UploadFile();
			file.setStorage(Integer.parseInt(storages[0]));
			if(fileUrls.length != 0) {
				file.setFileUrl(fileUrls[0]);
			}
			if(fileNames.length != 0) {
				file.setFileName(fileNames[0]);
			}
			if(extensions.length != 0) {
				file.setExtension(extensions[0]);
			}
			og.setFile(file);
		}
		
		OrderDTO dto = new OrderDTO();
		dto.setOrder(order);
		dto.setOrderGoods(goods);
		dto.setOrderAddress(orderAddress);
		return dto;
	}
}

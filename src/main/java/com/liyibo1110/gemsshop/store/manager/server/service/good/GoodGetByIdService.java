package com.liyibo1110.gemsshop.store.manager.server.service.good;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.Good;
import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;
import com.liyibo1110.gemsshop.store.manager.server.entity.UploadFile;

@Service
public class GoodGetByIdService extends BaseGoodService{

	private static Logger logger = LoggerFactory.getLogger(GoodGetByIdService.class);
	
	public Good get(StoreUser user, Integer id){
	
		Good good = goodDao.getById(id, user.getStoreId());
		//追加图片
		List<UploadFile> uploadFileList = uploadFileDao.getByGoodId(user.getStoreId(), id);
		good.setFileList(uploadFileList);
		return good;
	}
}

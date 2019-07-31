package com.liyibo1110.gemsshop.store.manager.server.service.good;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liyibo1110.gemsshop.store.manager.server.entity.Good;
import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;
import com.liyibo1110.gemsshop.store.manager.server.entity.UploadFile;

@Service
public class GoodListService extends BaseGoodService{

	private static Logger logger = LoggerFactory.getLogger(GoodListService.class);
	
	public List<Good> list(StoreUser user, String name, 
							Integer limit, Integer offset){
	
		List<Good> list = goodDao.getList(user.getStoreId(), name, limit, offset);
		for(Good g : list) {
			String storageStr = g.getStorageStr();
			String fileUrlStr = g.getFileUrlStr();
			String fileNameStr = g.getFileNameStr();
			String extensionStr = g.getExtensionStr();
			if(StringUtils.isBlank(storageStr)) continue;
			String[] storages = StringUtils.split(storageStr, ",");
			String[] fileUrls = StringUtils.split(fileUrlStr, ",");
			String[] fileNames = StringUtils.split(fileNameStr, ",");
			String[] extensions = StringUtils.split(extensionStr, ",");
			//logger.info("storages.size:" + storages.length);
			//生成图片对象集合
			List<UploadFile> fileList = new ArrayList<>();
			for(int i=0; i<storages.length; i++) {
				UploadFile file = new UploadFile();
				file.setStorage(Integer.parseInt(storages[i]));
				if(fileUrls.length != 0) {
					file.setFileUrl(fileUrls[i]);
				}
				if(fileNames.length != 0) {
					file.setFileName(fileNames[i]);
				}
				if(extensions.length != 0) {
					file.setExtension(extensions[i]);
				}
				fileList.add(file);
			}
			g.setFileList(fileList);
		}
		return list;
	}
}

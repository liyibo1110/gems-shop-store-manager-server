package com.liyibo1110.gemsshop.store.manager.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liyibo1110.gemsshop.store.manager.server.entity.UploadFile;

/**
 * 
 * @author liyibo
 *
 */
public interface UploadFileDao {
	
	public List<UploadFile> getList(@Param("storeId")Integer storeId, 
									@Param("groupId")Integer groupId);	
	
	public List<UploadFile> getByGoodId(@Param("storeId")Integer storeId, 
										@Param("goodId")Integer goodId);
	
	public int modify(@Param("storeId")Integer storeId, 
			  		@Param("ids")String ids,
			  		@Param("groupId")Integer groupId);
	
	public int create(@Param("storeId")Integer storeId, 
					  @Param("storage")Integer storage,
					  @Param("fileUrl")String fileUrl,
					  @Param("fileName")String fileName,
					  @Param("fileSize")Long fileSize,
					  @Param("fileType")Integer fileType,
					  @Param("extension")String extension);	
}

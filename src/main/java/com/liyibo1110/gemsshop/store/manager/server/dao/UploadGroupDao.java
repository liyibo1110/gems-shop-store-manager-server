package com.liyibo1110.gemsshop.store.manager.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liyibo1110.gemsshop.store.manager.server.entity.UploadGroup;

/**
 * 
 * @author liyibo
 *
 */
public interface UploadGroupDao {
	
	public List<UploadGroup> getAll(@Param("storeId")Integer storeId);	
	
	public int create(@Param("storeId")Integer storeId, 
					  @Param("type")Integer type,
					  @Param("name")String name,
					  @Param("sort")Integer sort);	
	
	public int modify(@Param("storeId")Integer storeId, 
					  @Param("id")Integer id,
					  @Param("name")String name);	
}

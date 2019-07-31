package com.liyibo1110.gemsshop.store.manager.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liyibo1110.gemsshop.store.manager.server.entity.Category;

/**
 * 
 * @author liyibo
 *
 */
public interface CategoryDao {
	
	public List<Category> getList(@Param("storeId")Integer storeId, 
								@Param("name")String name, 
								@Param("limit")Integer limit,
								@Param("offset")Integer offset);	
	
	public List<Category> getAll(@Param("storeId")Integer storeId);	
	
	public int getCount(@Param("storeId")Integer storeId, 
		    				@Param("name")String name);	
	
	public int create(@Param("storeId")Integer storeId, 
					  @Param("name")String name,
					  @Param("sort")Integer sort);	
	
	public int modify(@Param("storeId")Integer storeId, 
					  @Param("id")Integer id,
					  @Param("name")String name,
					  @Param("sort")Integer sort);	
}

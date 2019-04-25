package com.liyibo1110.gemsshop.store.manager.server.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liyibo1110.gemsshop.store.manager.server.dto.OutputDTO;
import com.liyibo1110.gemsshop.store.manager.server.entity.Category;
import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;
import com.liyibo1110.gemsshop.store.manager.server.service.category.CategoryCountService;
import com.liyibo1110.gemsshop.store.manager.server.service.category.CategoryCreateService;
import com.liyibo1110.gemsshop.store.manager.server.service.category.CategoryListService;
import com.liyibo1110.gemsshop.store.manager.server.service.category.CategoryModifyService;
import com.liyibo1110.gemsshop.store.manager.server.util.Constants;
import com.liyibo1110.gemsshop.store.manager.server.util.JsonUtils;

/**
 * 
 * @author liyibo
 *
 */
@Controller
public class CategoryController {

	private static Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryListService categoryListService;
	
	@Autowired
	private CategoryCountService categoryCountService;
	
	@Autowired
	private CategoryCreateService categoryCreateService;
	
	@Autowired
	private CategoryModifyService categoryModifyService;
	
	@RequestMapping("/api/category/list")
	public void list(HttpServletRequest request, HttpServletResponse response,
			String name, Integer limit, 
			Integer offset){
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		List<Category> list = categoryListService.list(user, name, limit, offset);
		JsonUtils.outputJsonp(response, new OutputDTO<List<Category>>(Constants.OUTPUTDTO_SUCCESS_STATUS, list));
	}
		
	@RequestMapping("/api/category/count")
	public void count(HttpServletRequest request, HttpServletResponse response,
						String name){
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		Integer count = categoryCountService.count(user, name);
		
		JsonUtils.outputJsonp(response, new OutputDTO<Integer>(Constants.OUTPUTDTO_SUCCESS_STATUS, count));
	}
	
	@RequestMapping("/api/category/create")
	public void create(HttpServletRequest request, HttpServletResponse response,
						String name, Integer sort){
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		Integer result = categoryCreateService.create(user, name, sort);
		
		JsonUtils.outputJsonp(response, new OutputDTO<Integer>(Constants.OUTPUTDTO_SUCCESS_STATUS, result));
	}
	
	@RequestMapping("/api/category/modify")
	public void modify(HttpServletRequest request, HttpServletResponse response,
						Integer id, String name, 
						Integer sort){
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		Integer result = categoryModifyService.modify(user, id, name, sort);
		
		JsonUtils.outputJsonp(response, new OutputDTO<Integer>(Constants.OUTPUTDTO_SUCCESS_STATUS, result));
	}
}

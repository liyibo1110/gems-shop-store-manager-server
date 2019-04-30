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
import com.liyibo1110.gemsshop.store.manager.server.entity.UploadGroup;
import com.liyibo1110.gemsshop.store.manager.server.service.uploadgroup.UploadGroupAllService;
import com.liyibo1110.gemsshop.store.manager.server.service.uploadgroup.UploadGroupCreateService;
import com.liyibo1110.gemsshop.store.manager.server.service.uploadgroup.UploadGroupModifyService;
import com.liyibo1110.gemsshop.store.manager.server.util.Constants;
import com.liyibo1110.gemsshop.store.manager.server.util.JsonUtils;

/**
 * 
 * @author liyibo
 *
 */
@Controller
public class UploadGroupController {

	private static Logger logger = LoggerFactory.getLogger(UploadGroupController.class);
	
	@Autowired
	private UploadGroupAllService uploadGroupAllService;
	
	@Autowired
	private UploadGroupCreateService uploadGroupCreateService;
	
	@Autowired
	private UploadGroupModifyService uploadGroupModifyService;
	
	@RequestMapping("/api/uploadGroup/all")
	public void list(HttpServletRequest request, HttpServletResponse response){
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		List<UploadGroup> list = uploadGroupAllService.all(user);
		JsonUtils.outputJsonp(response, new OutputDTO<List<UploadGroup>>(Constants.OUTPUTDTO_SUCCESS_STATUS, list));
	}
	
	@RequestMapping("/api/uploadGroup/create")
	public void create(HttpServletRequest request, HttpServletResponse response,
						Integer type, String name, Integer sort){
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		Integer result = uploadGroupCreateService.create(user, type, name, sort);
		
		JsonUtils.outputJsonp(response, new OutputDTO<Integer>(Constants.OUTPUTDTO_SUCCESS_STATUS, result));
	}
	
	@RequestMapping("/api/uploadGroup/modify")
	public void modify(HttpServletRequest request, HttpServletResponse response,
						Integer id, String name){
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		Integer result = uploadGroupModifyService.modify(user, id, name);
		
		JsonUtils.outputJsonp(response, new OutputDTO<Integer>(Constants.OUTPUTDTO_SUCCESS_STATUS, result));
	}
}

package com.liyibo1110.gemsshop.store.manager.server.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liyibo1110.gemsshop.store.manager.server.dto.NullDTO;
import com.liyibo1110.gemsshop.store.manager.server.dto.OutputDTO;
import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;
import com.liyibo1110.gemsshop.store.manager.server.service.storeuser.LoginService;
import com.liyibo1110.gemsshop.store.manager.server.service.storeuser.ModifyPasswordService;
import com.liyibo1110.gemsshop.store.manager.server.util.Constants;
import com.liyibo1110.gemsshop.store.manager.server.util.JsonUtils;

/**
 * 
 * @author liyibo
 *
 */
@Controller
public class StoreUserController {
	
	private static Logger logger = LoggerFactory.getLogger(StoreUserController.class);
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private ModifyPasswordService modifyPasswordService;
	
	@RequestMapping(value="/api/storeUser/login", method=RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse response,
						String username, String password){
		StoreUser user = loginService.login(username, password);
		if(user == null){	
			JsonUtils.outputJsonp(response, new OutputDTO<NullDTO>(Constants.OUTPUTDTO_FAILED_STATUS, 
																   Constants.OUTPUTDTO_INVAILD_USERNAME_ERRORCODE, 
																   Constants.OUTPUTDTO_INVAILD_USERNAME_ERRORCODE_MESSAGE, 
					    									       new NullDTO()));
		}else{
			JsonUtils.outputJsonp(response, new OutputDTO<StoreUser>(Constants.OUTPUTDTO_SUCCESS_STATUS, user));
		}
	}
	
	@RequestMapping(value="/api/storeUser/savePassword", method=RequestMethod.POST)
	public void savePassword(HttpServletRequest request, HttpServletResponse response,
						String password){
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		Integer result = modifyPasswordService.modify(user.getId(), password);
		JsonUtils.outputJsonp(response, new OutputDTO<Integer>(Constants.OUTPUTDTO_SUCCESS_STATUS, result));	
	}
	
	@RequestMapping(value="/api/storeUser/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response){
		//啥也不干
		JsonUtils.outputJsonp(response, new OutputDTO<NullDTO>(Constants.OUTPUTDTO_SUCCESS_STATUS, new NullDTO()));
	}
}

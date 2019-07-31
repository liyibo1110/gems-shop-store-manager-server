package com.liyibo1110.gemsshop.store.manager.server.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.liyibo1110.gemsshop.store.manager.server.dto.OutputDTO;
import com.liyibo1110.gemsshop.store.manager.server.entity.Delivery;
import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;
import com.liyibo1110.gemsshop.store.manager.server.service.delivery.DeliveryAllService;
import com.liyibo1110.gemsshop.store.manager.server.service.delivery.DeliveryCountService;
import com.liyibo1110.gemsshop.store.manager.server.service.delivery.DeliveryCreateService;
import com.liyibo1110.gemsshop.store.manager.server.service.delivery.DeliveryGetByIdService;
import com.liyibo1110.gemsshop.store.manager.server.service.delivery.DeliveryListService;
import com.liyibo1110.gemsshop.store.manager.server.service.delivery.DeliveryModifyService;
import com.liyibo1110.gemsshop.store.manager.server.util.Constants;
import com.liyibo1110.gemsshop.store.manager.server.util.JsonUtils;
import com.liyibo1110.gemsshop.store.manager.server.vo.DeliveryRuleVO;

/**
 * 
 * @author liyibo
 *
 */
@Controller
public class DeliveryController {

	private static Logger logger = LoggerFactory.getLogger(DeliveryController.class);
	
	@Autowired
	private DeliveryAllService deliveryAllService;
	
	@Autowired
	private DeliveryListService deliveryListService;
	
	@Autowired
	private DeliveryCountService deliveryCountService;
	
	@Autowired
	private DeliveryCreateService deliveryCreateService;
	
	@Autowired
	private DeliveryModifyService deliveryModifyService;
	
	@Autowired
	private DeliveryGetByIdService deliveryGetByIdService;
	
	@RequestMapping("/api/delivery/all")
	public void all(HttpServletRequest request, HttpServletResponse response){
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		List<Delivery> list = deliveryAllService.all(user);
		JsonUtils.outputJsonp(response, new OutputDTO<List<Delivery>>(Constants.OUTPUTDTO_SUCCESS_STATUS, list));
	}
	
	@RequestMapping("/api/delivery/list")
	public void list(HttpServletRequest request, HttpServletResponse response,
			String name, Integer limit, 
			Integer offset){
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		List<Delivery> list = deliveryListService.list(user, name, limit, offset);
		JsonUtils.outputJsonp(response, new OutputDTO<List<Delivery>>(Constants.OUTPUTDTO_SUCCESS_STATUS, list));
	}
		
	@RequestMapping("/api/delivery/count")
	public void count(HttpServletRequest request, HttpServletResponse response,
						String name){
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		Integer count = deliveryCountService.count(user, name);
		
		JsonUtils.outputJsonp(response, new OutputDTO<Integer>(Constants.OUTPUTDTO_SUCCESS_STATUS, count));
	}
	
	@RequestMapping("/api/delivery/create")
	public void create(HttpServletRequest request, HttpServletResponse response,
						String name, String rules, 
						Integer method, Integer sort){
		
		List<DeliveryRuleVO> ruleList = JSON.parseArray(rules, DeliveryRuleVO.class);
		/*logger.info("ruleList大小为：" + ruleList.size());
		for(DeliveryRule rule : ruleList) {
			logger.info("rule的cities为：" + rule.getCities());
		}*/
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		Integer result = deliveryCreateService.create(user, name, method, sort, ruleList);
		
		JsonUtils.outputJsonp(response, new OutputDTO<Integer>(Constants.OUTPUTDTO_SUCCESS_STATUS, result));
	}
	
	@RequestMapping("/api/delivery/modify")
	public void modify(HttpServletRequest request, HttpServletResponse response,
						Integer id, String name, String rules, 
						Integer method, Integer sort){
		
		List<DeliveryRuleVO> ruleList = JSON.parseArray(rules, DeliveryRuleVO.class);
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		Integer result = deliveryModifyService.modify(user, id, name, method, sort, ruleList);
		
		JsonUtils.outputJsonp(response, new OutputDTO<Integer>(Constants.OUTPUTDTO_SUCCESS_STATUS, result));
	}
	
	@RequestMapping("/api/delivery/getById")
	public void getById(HttpServletRequest request, HttpServletResponse response,
					Integer id){
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		Delivery delivery = deliveryGetByIdService.get(user, id);
		JsonUtils.outputJsonp(response, new OutputDTO<Delivery>(Constants.OUTPUTDTO_SUCCESS_STATUS, delivery));
	}
	
	/*
	@RequestMapping("/api/category/modify")
	public void modify(HttpServletRequest request, HttpServletResponse response,
						Integer id, String name, 
						Integer sort){
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		Integer result = categoryModifyService.modify(user, id, name, sort);
		
		JsonUtils.outputJsonp(response, new OutputDTO<Integer>(Constants.OUTPUTDTO_SUCCESS_STATUS, result));
	}*/
}

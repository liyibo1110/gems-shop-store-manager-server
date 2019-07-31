package com.liyibo1110.gemsshop.store.manager.server.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liyibo1110.gemsshop.store.manager.server.dto.OutputDTO;
import com.liyibo1110.gemsshop.store.manager.server.entity.Good;
import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;
import com.liyibo1110.gemsshop.store.manager.server.service.good.GoodCountService;
import com.liyibo1110.gemsshop.store.manager.server.service.good.GoodCreateService;
import com.liyibo1110.gemsshop.store.manager.server.service.good.GoodGetByIdService;
import com.liyibo1110.gemsshop.store.manager.server.service.good.GoodListService;
import com.liyibo1110.gemsshop.store.manager.server.service.good.GoodModifyService;
import com.liyibo1110.gemsshop.store.manager.server.util.Constants;
import com.liyibo1110.gemsshop.store.manager.server.util.JsonUtils;

/**
 * 
 * @author liyibo
 *
 */
@Controller
public class GoodController {

	private static Logger logger = LoggerFactory.getLogger(GoodController.class);
	
	@Autowired
	private GoodListService goodListService;
	
	@Autowired
	private GoodCountService goodCountService;
	
	@Autowired
	private GoodCreateService goodCreateService;
	
	@Autowired
	private GoodModifyService goodModifyService;
	
	@Autowired
	private GoodGetByIdService goodGetByIdService;
	
	@RequestMapping("/api/good/list")
	public void list(HttpServletRequest request, HttpServletResponse response,
			String name, Integer limit, 
			Integer offset){
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		List<Good> list = goodListService.list(user, name, limit, offset);
		JsonUtils.outputJsonp(response, new OutputDTO<List<Good>>(Constants.OUTPUTDTO_SUCCESS_STATUS, list));
	}
		
	@RequestMapping("/api/good/count")
	public void count(HttpServletRequest request, HttpServletResponse response,
						String name){
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		Integer count = goodCountService.count(user, name);
		
		JsonUtils.outputJsonp(response, new OutputDTO<Integer>(Constants.OUTPUTDTO_SUCCESS_STATUS, count));
	}
	
	@RequestMapping("/api/good/create")
	public void create(HttpServletRequest request, HttpServletResponse response,
					String name, Integer categoryId, 
					String imageIds, Integer specType, 
					String no, BigDecimal price, 
					BigDecimal linePrice, Integer stockNum, 
					BigDecimal weight,
					Integer deductStockType, String content, 
					Integer deliveryId, Integer status, 
					Integer salesInitial, Integer sort){
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		Integer result = goodCreateService.create(user, name, categoryId, imageIds, specType, 
												no, price, linePrice, stockNum, weight, 
												deductStockType, content, deliveryId, status, salesInitial, 
												sort);
		
		JsonUtils.outputJsonp(response, new OutputDTO<Integer>(Constants.OUTPUTDTO_SUCCESS_STATUS, result));
	}
	
	@RequestMapping("/api/good/modify")
	public void modify(HttpServletRequest request, HttpServletResponse response,
						Integer id, String name, Integer categoryId, 
						String imageIds, Integer specType, 
						String no, BigDecimal price, 
						BigDecimal linePrice, Integer stockNum, 
						BigDecimal weight, Integer deductStockType, 
						String content, Integer deliveryId, 
						Integer status, Integer salesInitial, 
						Integer sort){
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		Integer result = goodModifyService.modify(user, id, name, categoryId, imageIds, specType, 
												no, price, linePrice, stockNum, weight, 
												deductStockType, content, deliveryId, status, salesInitial, 
												sort);
		
		JsonUtils.outputJsonp(response, new OutputDTO<Integer>(Constants.OUTPUTDTO_SUCCESS_STATUS, result));
	}
	
	@RequestMapping("/api/good/getById")
	public void getById(HttpServletRequest request, HttpServletResponse response,
					Integer id){
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		Good good = goodGetByIdService.get(user, id);
		JsonUtils.outputJsonp(response, new OutputDTO<Good>(Constants.OUTPUTDTO_SUCCESS_STATUS, good));
	}
}

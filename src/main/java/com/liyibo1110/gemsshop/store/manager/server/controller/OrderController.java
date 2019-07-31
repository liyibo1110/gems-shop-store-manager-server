package com.liyibo1110.gemsshop.store.manager.server.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liyibo1110.gemsshop.store.manager.server.dto.OrderDTO;
import com.liyibo1110.gemsshop.store.manager.server.dto.OutputDTO;
import com.liyibo1110.gemsshop.store.manager.server.entity.Order;
import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;
import com.liyibo1110.gemsshop.store.manager.server.service.order.OrderCountService;
import com.liyibo1110.gemsshop.store.manager.server.service.order.OrderGetByIdService;
import com.liyibo1110.gemsshop.store.manager.server.service.order.OrderListService;
import com.liyibo1110.gemsshop.store.manager.server.service.order.OrderModifyDeliveryStatusService;
import com.liyibo1110.gemsshop.store.manager.server.util.Constants;
import com.liyibo1110.gemsshop.store.manager.server.util.JsonUtils;

/**
 * 
 * @author liyibo
 *
 */
@Controller
public class OrderController {

	private static Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderListService orderListService;
	
	@Autowired
	private OrderCountService orderCountService;
	
	@Autowired
	private OrderGetByIdService orderGetByIdService;
	
	@Autowired
	private OrderModifyDeliveryStatusService orderModifyDeliveryStatusService;
	
	@RequestMapping("/api/order/list")
	public void list(HttpServletRequest request, HttpServletResponse response,
			Integer payStatus, Integer deliveryStatus, 
			Integer receiptStatus, Integer limit, 
			Integer offset){
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		List<Order> list = orderListService.list(user, payStatus, deliveryStatus, receiptStatus, limit, offset);
		JsonUtils.outputJsonp(response, new OutputDTO<List<Order>>(Constants.OUTPUTDTO_SUCCESS_STATUS, list));
	}
		
	@RequestMapping("/api/order/count")
	public void count(HttpServletRequest request, HttpServletResponse response,
			Integer payStatus, Integer deliveryStatus, 
			Integer receiptStatus){
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		Integer count = orderCountService.count(user, payStatus, deliveryStatus, receiptStatus);
		
		JsonUtils.outputJsonp(response, new OutputDTO<Integer>(Constants.OUTPUTDTO_SUCCESS_STATUS, count));
	}
	
	@RequestMapping("/api/order/getById")
	public void getById(HttpServletRequest request, HttpServletResponse response,
			Integer id){
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		OrderDTO dto = orderGetByIdService.get(user, id);
		JsonUtils.outputJsonp(response, new OutputDTO<OrderDTO>(Constants.OUTPUTDTO_SUCCESS_STATUS, dto));
	}
	
	@RequestMapping("/api/order/modifyDeliveryStatus")
	public void modifyDeliveryStatus(HttpServletRequest request, HttpServletResponse response,
						Integer id, String companyName, String no){
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		logger.info("companyName:" + companyName);
		logger.info("no:" + no);
		Integer result = orderModifyDeliveryStatusService.modify(user, id, companyName, no);
		JsonUtils.outputJsonp(response, new OutputDTO<Integer>(Constants.OUTPUTDTO_SUCCESS_STATUS, result));
	}
	
}

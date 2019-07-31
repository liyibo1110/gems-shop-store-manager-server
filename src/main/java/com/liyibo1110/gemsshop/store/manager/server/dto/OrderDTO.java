package com.liyibo1110.gemsshop.store.manager.server.dto;

import java.util.List;

import com.liyibo1110.gemsshop.store.manager.server.entity.Order;
import com.liyibo1110.gemsshop.store.manager.server.entity.OrderAddress;
import com.liyibo1110.gemsshop.store.manager.server.entity.OrderGood;

public class OrderDTO {

	private Order order;
	private List<OrderGood> orderGoods;
	private OrderAddress orderAddress;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<OrderGood> getOrderGoods() {
		return orderGoods;
	}
	public void setOrderGoods(List<OrderGood> orderGoods) {
		this.orderGoods = orderGoods;
	}
	public OrderAddress getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(OrderAddress orderAddress) {
		this.orderAddress = orderAddress;
	}
}

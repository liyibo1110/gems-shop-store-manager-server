package com.liyibo1110.gemsshop.store.manager.server.entity;

import java.sql.Timestamp;
import java.util.List;

public class Delivery {

	private Integer id;
	private String name;
	private Integer method;
	private Integer sort;
	private Integer storeId;
	
	private Timestamp addTime;
	private Timestamp updateTime;
	private List<DeliveryRule> rules;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMethod() {
		return method;
	}
	public void setMethod(Integer method) {
		this.method = method;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public Timestamp getAddTime() {
		return addTime;
	}
	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public List<DeliveryRule> getRules() {
		return rules;
	}
	public void setRules(List<DeliveryRule> rules) {
		this.rules = rules;
	}
}

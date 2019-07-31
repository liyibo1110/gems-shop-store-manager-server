package com.liyibo1110.gemsshop.store.manager.server.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.liyibo1110.gemsshop.store.manager.server.util.ListUtils;

public class DeliveryRule {

	private Integer id;
	private Integer deliveryId;
	private String regionStr;
	private List<Integer> region;
	private Double first;
	private BigDecimal firstFee;
	
	private Double additional;
	private BigDecimal additionalFee;
	private Integer storeId;
	private Timestamp addTime;
	private Timestamp updateTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Integer deliveryId) {
		this.deliveryId = deliveryId;
	}
	public String getRegionStr() {
		return regionStr;
	}
	public void setRegionStr(String regionStr) {
		this.regionStr = regionStr;
	}
	public List<Integer> getRegion() {
		if(StringUtils.isNotBlank(this.regionStr)) {
			return ListUtils.stringToIntegerList(this.regionStr);
		}else {
			return null;
		}
	}
	public void setRegion(List<Integer> region) {
		this.region = region;
	}
	public Double getFirst() {
		return first;
	}
	public void setFirst(Double first) {
		this.first = first;
	}
	public BigDecimal getFirstFee() {
		return firstFee;
	}
	public void setFirstFee(BigDecimal firstFee) {
		this.firstFee = firstFee;
	}
	public Double getAdditional() {
		return additional;
	}
	public void setAdditional(Double additional) {
		this.additional = additional;
	}
	public BigDecimal getAdditionalFee() {
		return additionalFee;
	}
	public void setAdditionalFee(BigDecimal additionalFee) {
		this.additionalFee = additionalFee;
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
}

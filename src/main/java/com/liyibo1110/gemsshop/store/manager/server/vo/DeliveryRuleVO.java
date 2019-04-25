package com.liyibo1110.gemsshop.store.manager.server.vo;

import java.util.List;

public class DeliveryRuleVO {

	private Integer id;
	private List<Integer> region;
	private String regionStr;
	private Integer first;
	private Double firstFee;
	private Integer additional;
	
	private Double additionalFee;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Integer> getRegion() {
		return region;
	}

	public void setRegion(List<Integer> region) {
		this.region = region;
	}

	public String getRegionStr() {
		return regionStr;
	}

	public void setRegionStr(String regionStr) {
		this.regionStr = regionStr;
	}

	public Integer getFirst() {
		return first;
	}

	public void setFirst(Integer first) {
		this.first = first;
	}

	public Double getFirstFee() {
		return firstFee;
	}

	public void setFirstFee(Double firstFee) {
		this.firstFee = firstFee;
	}

	public Integer getAdditional() {
		return additional;
	}

	public void setAdditional(Integer additional) {
		this.additional = additional;
	}

	public Double getAdditionalFee() {
		return additionalFee;
	}

	public void setAdditionalFee(Double additionalFee) {
		this.additionalFee = additionalFee;
	}
}

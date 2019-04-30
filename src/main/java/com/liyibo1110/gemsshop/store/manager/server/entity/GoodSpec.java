package com.liyibo1110.gemsshop.store.manager.server.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class GoodSpec {

	private Integer id;
	private Integer goodId;
	private String no;
	private BigDecimal price;
	private BigDecimal linePrice;
	
	private Integer stockNum;
	private Integer sales;	//应该是这个规格的销量
	private BigDecimal weight;
	private Integer storeId;
	private String specSkuId;
	
	private Timestamp addTime;
	private Timestamp updateTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGoodId() {
		return goodId;
	}
	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getLinePrice() {
		return linePrice;
	}
	public void setLinePrice(BigDecimal linePrice) {
		this.linePrice = linePrice;
	}
	public Integer getStockNum() {
		return stockNum;
	}
	public void setStockNum(Integer stockNum) {
		this.stockNum = stockNum;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public String getSpecSkuId() {
		return specSkuId;
	}
	public void setSpecSkuId(String specSkuId) {
		this.specSkuId = specSkuId;
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

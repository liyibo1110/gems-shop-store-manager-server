package com.liyibo1110.gemsshop.store.manager.server.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class OrderGood {

	private Integer id;
	private Integer goodId;
	private String goodName;
	private Integer imageId;
	private Integer deductStockType;
	
	private Integer specType;
	private String specSkuId;
	private Integer specId;
	private String attr;
	private String content;
	
	private String no;
	private BigDecimal price;
	private BigDecimal linePrice;
	private BigDecimal weight;
	private Integer totalNum;
	
	private BigDecimal totalPrice;
	private Integer orderId;
	private Integer userId;
	private Integer storeId;
	private Timestamp addTime;
	
	//关联图片表
	private List<UploadFile> fileList;
	private String storageStr;
	private String fileUrlStr;
	private String fileNameStr;
	private String extensionStr;
	
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
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	public Integer getDeductStockType() {
		return deductStockType;
	}
	public void setDeductStockType(Integer deductStockType) {
		this.deductStockType = deductStockType;
	}
	public Integer getSpecType() {
		return specType;
	}
	public void setSpecType(Integer specType) {
		this.specType = specType;
	}
	public String getSpecSkuId() {
		return specSkuId;
	}
	public void setSpecSkuId(String specSkuId) {
		this.specSkuId = specSkuId;
	}
	public Integer getSpecId() {
		return specId;
	}
	public void setSpecId(Integer specId) {
		this.specId = specId;
	}
	public String getAttr() {
		return attr;
	}
	public void setAttr(String attr) {
		this.attr = attr;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public List<UploadFile> getFileList() {
		return fileList;
	}
	public void setFileList(List<UploadFile> fileList) {
		this.fileList = fileList;
	}
	public String getStorageStr() {
		return storageStr;
	}
	public void setStorageStr(String storageStr) {
		this.storageStr = storageStr;
	}
	public String getFileUrlStr() {
		return fileUrlStr;
	}
	public void setFileUrlStr(String fileUrlStr) {
		this.fileUrlStr = fileUrlStr;
	}
	public String getFileNameStr() {
		return fileNameStr;
	}
	public void setFileNameStr(String fileNameStr) {
		this.fileNameStr = fileNameStr;
	}
	public String getExtensionStr() {
		return extensionStr;
	}
	public void setExtensionStr(String extensionStr) {
		this.extensionStr = extensionStr;
	}
}

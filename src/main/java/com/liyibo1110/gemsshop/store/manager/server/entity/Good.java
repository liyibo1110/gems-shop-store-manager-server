package com.liyibo1110.gemsshop.store.manager.server.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class Good {

	private Integer id;
	private String name;
	private Integer categoryId;
	private Integer specType;
	private Integer deductStockType;
	
	private String content;
	private Integer salesInitial;
	private Integer salesActual;
	private Integer sort;
	private Integer deliveryId;
	
	private Integer status;
	private Integer deleted;
	private Integer storeId;
	private Timestamp addTime;
	private Timestamp updateTime;
	
	//关联其它
	private String categoryName;
	private Integer totalNum;
	
	//关联单规格表
	private String no;
	private BigDecimal price;
	private BigDecimal linePrice;
	private Integer stockNum;
	private Integer sales;
	private BigDecimal weight;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getSpecType() {
		return specType;
	}
	public void setSpecType(Integer specType) {
		this.specType = specType;
	}
	public Integer getDeductStockType() {
		return deductStockType;
	}
	public void setDeductStockType(Integer deductStockType) {
		this.deductStockType = deductStockType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getSalesInitial() {
		return salesInitial;
	}
	public void setSalesInitial(Integer salesInitial) {
		this.salesInitial = salesInitial;
	}
	public Integer getSalesActual() {
		return salesActual;
	}
	public void setSalesActual(Integer salesActual) {
		this.salesActual = salesActual;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Integer deliveryId) {
		this.deliveryId = deliveryId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
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

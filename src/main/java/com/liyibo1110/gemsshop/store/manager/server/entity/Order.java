package com.liyibo1110.gemsshop.store.manager.server.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class Order {

	private Integer id;
	private String orderNo;
	private BigDecimal totalPrice;
	private BigDecimal payPrice;
	private Integer payStatus;
	
	private Timestamp payTime;
	private BigDecimal expressPrice;
	private String expressCompany;
	private String expressNo;
	private Integer deliveryStatus;
	
	private Timestamp deliveryTime;
	private Integer receiptStatus;
	private Timestamp receiptTime;
	private Integer orderStatus;
	private String transactionId;
	
	private Integer userId;
	private Integer storeId;
	private Timestamp addTime;
	private Timestamp updateTime;
	
	//关联用户表
	private String nickname;
	
	//关联产品表
	private List<Good> goodList;
	private String goodsIdStr;
	private String goodsNameStr;
	private String goodsPriceStr;
	private String goodsTotalNumStr;
	
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
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public BigDecimal getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(BigDecimal payPrice) {
		this.payPrice = payPrice;
	}
	public Integer getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
	public Timestamp getPayTime() {
		return payTime;
	}
	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
	}
	public BigDecimal getExpressPrice() {
		return expressPrice;
	}
	public void setExpressPrice(BigDecimal expressPrice) {
		this.expressPrice = expressPrice;
	}
	public String getExpressCompany() {
		return expressCompany;
	}
	public void setExpressCompany(String expressCompany) {
		this.expressCompany = expressCompany;
	}
	public String getExpressNo() {
		return expressNo;
	}
	public void setExpressNo(String expressNo) {
		this.expressNo = expressNo;
	}
	public Integer getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(Integer deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public Timestamp getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Timestamp deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public Integer getReceiptStatus() {
		return receiptStatus;
	}
	public void setReceiptStatus(Integer receiptStatus) {
		this.receiptStatus = receiptStatus;
	}
	public Timestamp getReceiptTime() {
		return receiptTime;
	}
	public void setReceiptTime(Timestamp receiptTime) {
		this.receiptTime = receiptTime;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public List<Good> getGoodList() {
		return goodList;
	}
	public void setGoodList(List<Good> goodList) {
		this.goodList = goodList;
	}
	public String getGoodsIdStr() {
		return goodsIdStr;
	}
	public void setGoodsIdStr(String goodsIdStr) {
		this.goodsIdStr = goodsIdStr;
	}
	public String getGoodsNameStr() {
		return goodsNameStr;
	}
	public void setGoodsNameStr(String goodsNameStr) {
		this.goodsNameStr = goodsNameStr;
	}
	public String getGoodsPriceStr() {
		return goodsPriceStr;
	}
	public void setGoodsPriceStr(String goodsPriceStr) {
		this.goodsPriceStr = goodsPriceStr;
	}
	public String getGoodsTotalNumStr() {
		return goodsTotalNumStr;
	}
	public void setGoodsTotalNumStr(String goodsTotalNumStr) {
		this.goodsTotalNumStr = goodsTotalNumStr;
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
	
	public static void main(String[] args) {
		
	}
}

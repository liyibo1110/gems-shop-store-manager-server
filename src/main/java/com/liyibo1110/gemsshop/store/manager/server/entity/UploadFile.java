package com.liyibo1110.gemsshop.store.manager.server.entity;

import java.sql.Timestamp;

public class UploadFile {

	private Integer id;
	private Integer storage;
	private Integer groupId;
	private String fileUrl;
	private String fileName;
	
	private Long fileSize;
	private Integer fileType;
	private String extension;
	private Integer deleted;
	private Integer main;
	
	private Integer storeId;
	private Timestamp addTime;
	private Timestamp updateTime;
	
	//冗余关联
	private Integer goodsId;
	private String goodsName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStorage() {
		return storage;
	}
	public void setStorage(Integer storage) {
		this.storage = storage;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public Integer getFileType() {
		return fileType;
	}
	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public Integer getMain() {
		return main;
	}
	public void setMain(Integer main) {
		this.main = main;
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
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
}

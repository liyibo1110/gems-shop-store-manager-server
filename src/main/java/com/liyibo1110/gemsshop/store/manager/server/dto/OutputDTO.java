package com.liyibo1110.gemsshop.store.manager.server.dto;

import java.io.Serializable;

/**
 * 用来做外层接口的封装类，对外最终传出该对象
 * @author liyibo
 *
 */
public class OutputDTO<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 58956968886082732L;
	
	private Integer status;
	private Integer errorcode;
	private String errormsg;
	private Long time;
	private T data;
	
	
	/**
	 * 限定构造方式
	 * @param status
	 * @param data
	 */
	public OutputDTO(Integer status, Integer errorcode, String errormsg, T data) {
		this.status = status;
		this.errorcode = errorcode;
		this.errormsg = errormsg;
		this.data = data;
	}
	
	/**
	 * 限定构造方式
	 * @param status
	 * @param data
	 */
	public OutputDTO(Integer status, T data) {
		this.status = status;
		this.errorcode = 0;
		this.errormsg = "";
		this.time = System.currentTimeMillis();
		this.data = data;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(Integer errorcode) {
		this.errorcode = errorcode;
	}
	
	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}
	
}

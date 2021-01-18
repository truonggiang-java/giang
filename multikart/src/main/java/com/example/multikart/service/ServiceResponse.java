package com.example.multikart.service;

public class ServiceResponse<T> {
	public Integer status;
	public T data;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ServiceResponse(Integer status, T data) {
		super();
		this.status = status;
		this.data = data;
	}
	public ServiceResponse() {
		super();
	}
	
	
}

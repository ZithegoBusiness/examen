package com.trnetwork.entity;

public class response <T>{
	private T id;
	private boolean status;
	
	public response()
	{
		
	}
	
	public response(T var, boolean status) {
		this.id = var;
		this.status = status;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
	
	
	

}

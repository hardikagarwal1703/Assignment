package com.app.customer;

public class CustomerAadhar {
	private String aadharNo;
	private String location;
	
	public CustomerAadhar(String aadharNo, String location) {
		super();
		this.aadharNo = aadharNo;
		this.location = location;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public String getLocation() {
		return location;
	}	
}
package com.app.customer;

import java.util.Date;

public class Customer {
	private static int id = 0;
	private String name;
	private String email;
	private String password;
	private double registrationAmount;
	private Date dob;
	private ServicePlan servicePlan;

	public Customer(String name, String email, String password, double registrationAmount, Date dob,
			ServicePlan servicePlan) {
		super();
		Customer.id ++;
		this.name = name;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.servicePlan = servicePlan;
	}

	public String getEmail() {
		return email;
	}
	public Date getDob() {
		return dob;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", registrationAmount=" + registrationAmount + ", dob=" + dob + ", servicePlan=" + servicePlan + "]";
	}
}
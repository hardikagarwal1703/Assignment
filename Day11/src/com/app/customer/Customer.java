package com.app.customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
	private int id;
	private static int idCounter;

	private static SimpleDateFormat sdf;

	private String name;
	private String email;
	private String password;
	private double registrationAmount;
	private Date dob;
	private ServicePlan servicePlan;
	private CustomerAadhar custAadhar;

	static {
		 sdf = new SimpleDateFormat("dd-MM-yyyy");
		 idCounter = 1;
	}

	public Customer(String name, String email, String password, double registrationAmount, Date dob,
			ServicePlan servicePlan) throws ParseException{
		super();
		this.id = idCounter++;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setAadharDetail(String aadharNumber, String location) {
		custAadhar = new CustomerAadhar(aadharNumber, location);
	}

	public String getAadharNumber() {
		return custAadhar.getAadharNo();
	}

	public ServicePlan getServicePlan() {
		return servicePlan;
	}

	public void setServicePlan(ServicePlan servicePlan) {
		this.servicePlan = servicePlan;
	}

	@Override
	public String toString() {
		if(custAadhar!=null) {
			return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
					+ ", registrationAmount=" + registrationAmount + ", dob=" + sdf.format(dob) + ", "
							+ "servicePlan=" + servicePlan 
					+" [ Aadhar Number= " + custAadhar.getAadharNo() + "Location:" + custAadhar.getLocation()
					+ "]" + "]";
		}
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", registrationAmount=" + registrationAmount + ", dob=" + sdf.format(dob) + ", "
						+ "servicePlan=" + servicePlan + "]";
	}
}
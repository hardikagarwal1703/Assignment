package com.app.operations;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.app.customer.Customer;
import com.app.exception.CustomerException;
import com.app.tester.ValidationRules;

public class LoginFacility {

	public Customer loginCustomer(Scanner scan, ArrayList<Customer> customerList) 
			throws CustomerException, ParseException{

		System.out.println("Welcome to Login Page!");

		System.out.println("Enter Correct Email:");
		String eMail = ValidationRules.validateEmailAddress(scan.nextLine()
					.toLowerCase()); 

		System.out.println("Enter Password:");
		String password = ValidationRules.validatePassword(scan.nextLine());

		System.out.println("Enter DOB:");
		Date dob = ValidationRules.validateDateOfBirth(scan.nextLine());

		Customer authorizedUser = checkForExistance(eMail, password, dob, customerList);
		if(authorizedUser!= null){
			return authorizedUser;
		}
		throw new CustomerException("Login Unsuccessfull!");
	}

	public static Customer checkForExistance(String checkEmail, String checkPassword, 
			Date checkDOB, ArrayList<Customer> customerList) throws CustomerException{

		for(int i=0; i<customerList.size(); i++) {
			if((customerList.get(i).getEmail().equals(checkEmail)) &&
					(customerList.get(i).getPassword().equals(checkPassword)) && 
						(customerList.get(i).getDob().compareTo(checkDOB)==0)) {
				return customerList.get(i);
			}
		}
		throw new CustomerException("");
	}
}
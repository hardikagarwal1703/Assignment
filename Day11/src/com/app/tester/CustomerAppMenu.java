package com.app.tester;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.app.customer.Customer;
import com.app.customer.ServicePlan;
import com.app.exception.CustomerException;
import com.app.operations.LoginFacility;

public class CustomerAppMenu {

	public static SimpleDateFormat sdf;
	public static Date checkDate;

	static {
		try {
			sdf = new SimpleDateFormat("dd-MM-yyyy");
			checkDate = sdf.parse("01-01-1962");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		try(Scanner scan = new Scanner(System.in)){

			LoginFacility lf = new LoginFacility();		
			Customer authorizedUser = null;

			for(boolean flag = true; flag;) {
				System.out.println("1. Customer Registration");
				System.out.println("2. Customer Login");
				System.out.println("3. Link Customer Aadhar");
				System.out.println("4. Change Password");
				System.out.println("5. Unsubscribe Customer");
				System.out.println("6. Upgrade All Senior Citizens");
				System.out.println("7. View Customers");
				System.out.println("10. Exit");
				System.out.println("Enter Choice");

				switch(Integer.parseInt(scan.nextLine())) {
					case 1:
							if(authorizedUser != null) {
								System.out.println("Logged Off User: "+authorizedUser.getName());
								authorizedUser = null;
							}

							System.out.println("Enter Name: ");
							String customerName = scan.nextLine();

							System.out.println("Enter e-Mail: ");
							String eMail = ValidationRules.validateEmailAddress(scan.nextLine()
									.toLowerCase());

							System.out.println("Enter Password: "
									+ "(Min 4, Max 10, Must Contain # @ $ % *");
							String password = ValidationRules.validatePassword(scan.nextLine());

							System.out.println("Enter Date of Birth");
							Date dob = ValidationRules.validateDateOfBirth(scan.nextLine());

							ValidationRules.checkForDuplicateCustomer(dob,eMail,customerList);

							System.out.println("Choose Service Plan:");
							for(ServicePlan plan: ServicePlan.values()) {
								System.out.print(plan + " ");
							}
							System.out.println("");
							ServicePlan sp = ValidationRules.validateServicePlan(scan.nextLine().toUpperCase());

							double regAmount = sp.getAmount();

							customerList.add(new Customer(customerName, eMail, password, regAmount, dob, sp));		
							break;

					case 2:	
							authorizedUser = lf.loginCustomer(scan, customerList);
							System.out.println("Login Success!!");
							break;

					case 3:	
							if(authorizedUser == null) {
								System.out.println("You Need To Login First");
								authorizedUser = lf.loginCustomer(scan, customerList);
								System.out.println("Login Success!!");
							}
							if(authorizedUser != null) {
								System.out.println("Enter Aadhar Details!");
								System.out.println("Enter Aadhar Number & Location.");
								authorizedUser.setAadharDetail(scan.nextLine(), scan.nextLine());
							}
							break;
					case 4:
							if(authorizedUser == null) {
								System.out.println("You Need To Login First");
								authorizedUser = lf.loginCustomer(scan, customerList);
								System.out.println("Login Success!!");
							}
							if(authorizedUser != null) {
								if(authorizedUser.getAadharNumber()!=null) {
									System.out.println("Your Purana Password = " 
											+ authorizedUser.getPassword());
									System.out.println("Enter New Pasword");
									String newPass = ValidationRules.validatePassword(scan.nextLine());
									authorizedUser.setPassword(newPass);
									System.out.println("New Password Set Successfully!");
								}
							}

							break;
					case 5:
							if(authorizedUser == null) {
								System.out.println("You Need To Login First");
								authorizedUser = lf.loginCustomer(scan, customerList);
								System.out.println("Login Success!!");
							}
							if(authorizedUser != null) {
								customerList.remove(authorizedUser);
								System.out.println("Removed User: " + authorizedUser.getName());
								authorizedUser=null;
							}
							break;

					case 6: 
							for(Customer seniorCitizen: customerList) {
								if((seniorCitizen.getDob().before(checkDate)) 
										&& (seniorCitizen.getServicePlan().name().toUpperCase().equals("DIAMOND"))) {
									seniorCitizen.setServicePlan(ServicePlan.valueOf("PLATINUM"));
								}
							}
							System.out.println("All Senior Citizens(if any) Upgraded from"
									+ " DAIMOND to PLATINUM plan");
							break;

					case 7: 
							System.out.println("Current Customers:");
							for(Customer customer: customerList) {
								System.out.println(customer);
							}
							System.out.println("");
							break;

					case 10:
							flag = false;
							break;
				}
			}
		}catch(IllegalArgumentException | CustomerException | ParseException | NullPointerException e) {
			e.getMessage();
			System.out.println(e.getMessage());
		}
	}
}
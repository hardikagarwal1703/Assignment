package com.app.tester;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import com.app.customer.Customer;
import com.app.customer.ServicePlan;
import com.app.exception.CustomerException;

public class AcceptValues {
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)){
			System.out.println("Enter Number of users: ");
			Customer[] customers = new Customer[Integer.parseInt(scan.nextLine())];

			for (int i = 0; i < customers.length; i++) {
				System.out.println("Enter Customer " + i + " Details:");

				System.out.println("Enter Name: ");
				String customerName = scan.nextLine();

				System.out.println("Enter e-Mail: ");
				String eMail = ValidationRules.validateEmailAddress(scan.nextLine().toLowerCase());

				System.out.println("Enter Password: "
						+ "(Min 4, Max 10, Must Contain # @ $ % *");
				String password = ValidationRules.validatePassword(scan.nextLine());

				System.out.println("Enter Date of Birth");
				Date dob = ValidationRules.validateDateOfBirth(scan.nextLine());

				//Checking for duplicate customer
				ValidationRules.checkForDuplicateCustomer(dob,eMail,customers,i);
				
				System.out.println("Choose Service Plan:");
				for(ServicePlan plan: ServicePlan.values()) {
					System.out.print(plan + " ");
				}
				System.out.println("");
				ServicePlan sp = ValidationRules.validateServicePlan(scan.nextLine().toUpperCase());

				double regAmount = sp.getAmount();

				customers[i] = new Customer(customerName, eMail, password, 
						regAmount, dob, sp);
			}

			//Displaying Customers
			System.out.println("\n\nSaved Customer:");
			for(Customer c: customers) {
				System.out.println(c);
			}

		}catch(CustomerException | ParseException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
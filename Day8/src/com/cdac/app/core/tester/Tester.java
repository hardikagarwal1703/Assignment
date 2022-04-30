package com.cdac.app.core.tester;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;


import com.cdac.app.core.Showroom.Color;
import com.cdac.app.core.Showroom.Validation;
import com.cdac.app.core.Showroom.Vehicle;
import com.cdac.app.core.exception.CustomNullPointerException;
import com.cdac.app.core.exception.DateOutOfRangeException;
import com.cdac.app.core.exception.DuplicateChasisException;
import com.cdac.app.core.exception.PriceOutOfRangeException;

public class Tester {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			
			System.out.println("Welcome To Our Car Showroom!!!\n\n");
			System.out.println("How many cars can your Showroom accomodate?");
			Vehicle[] vehicles = new Vehicle[Integer.parseInt(scan.next())];
			
			int i=0;
			for(boolean flag = true; flag;) {
				
				System.out.println("\nChoose one of the following:\n"
						+ "1. Add Vehicle\n"
						+ "2. Display Vehicle\n"
						+ "10. Exit");

				switch(Integer.parseInt(scan.next())) {

					case 1:	try{
								if(i != vehicles.length) {
									System.out.println("Enter Data of Vehicle");
									System.out.println("Chasis No(String)");
									//Check for duplicate entry of cars up-till current entry i
									// i becomes the upper-bound for my loop in isDuplicate function
									//and throws custom DuplicateChasisEntry error.
									String chasisNo = Validation.isDuplicate(scan.next(), vehicles, i);
									
									System.out.println("Choose Color(String)\n");
									
									//Shows all color options from Enumeration
									for(Color c: Color.values()) {
										System.out.print(c + " ");
									}
									//took color value by enum in built function valueOf which
									//throws IllegalArgumentException (in built exception)
									Color color = Color.valueOf(scan.next().toUpperCase());
									
									System.out.println("\n\nEnter Price(Double)");
									//Called static function to validate price within range
									//throws custom exception PriceOutOfRange
									Double price = Validation.isPriceInRange(Double.parseDouble(scan.next()));
										
									System.out.println("Enter Manf. Date(dd-MM-YYYY)");
									//Parsing date in "dd-MM-yyyy" format
									//throws checked ParseException & custom DateOutOfRangeException
									Date mfd = Validation.isDateInRange(scan.next());
									
									//Creating elements in vehicle array if all goes good.
									vehicles[i++] = new Vehicle(chasisNo,color,price,mfd);
								} else {
									System.out.println("\nShowroom is full!\n");
								}
								
							}catch(IllegalArgumentException | PriceOutOfRangeException | ParseException | DateOutOfRangeException | DuplicateChasisException e1) {
								if(e1 instanceof IllegalArgumentException) {
									System.out.println("Color not available!!");
								}else {
									System.out.println(e1.getMessage());
								}		
							}
							break;
					
					case 2: 
							try{
								System.out.println("Currently Vehicles in Showroom: ");
								int counter = 0;
								for(Vehicle v: vehicles) {
									if(v == null) {
										if(counter == 0) {
											throw new CustomNullPointerException("Showroom is Empty");
										}
										throw new CustomNullPointerException("");
									}
									System.out.println(v);
									counter += 1;
								}
							}catch(CustomNullPointerException e) {
								if(!"".equals(e.getMessage())){
									System.out.println("\n"+e.getMessage()+"\n");
								}
								break;
							}
							break;
						
					case 10: flag = false;

				}
			}
			
		}
	}

}

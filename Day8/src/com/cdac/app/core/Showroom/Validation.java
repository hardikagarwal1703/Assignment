package com.cdac.app.core.Showroom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cdac.app.core.exception.DateOutOfRangeException;
import com.cdac.app.core.exception.DuplicateChasisException;
import com.cdac.app.core.exception.PriceOutOfRangeException;

public class Validation {
	private static double MIN_PRICE = 10000d;
	private static double MAX_PRICE = 100000d;
	private static String START_DATE = "01-04-2022";
	private static String END_DATE = "31-03-2023";
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); 
	
	public static double isPriceInRange(double price) throws PriceOutOfRangeException{
		if((price >= MIN_PRICE) && (price <= MAX_PRICE)) {
			return price;
		}
		throw new PriceOutOfRangeException("Price not in range! Allowed 10000-100000");
	}
	
	public static Date isDateInRange(String date) throws ParseException,DateOutOfRangeException{
		Date checkDate = sdf.parse(date);
		Date startDate = sdf.parse(START_DATE);
		Date endDate = sdf.parse(END_DATE);
		
		if((checkDate.after(startDate)) && (checkDate.before(endDate))) {
			return checkDate;
		}
		throw new DateOutOfRangeException("Mfd. Date not in range! Allowed 01-04-2022 -> 31-03-2023");
	}
	
	public static String isDuplicate(String checkChasis, Vehicle[] vehicles, int upperBound) throws DuplicateChasisException{
		if(upperBound != 0) {
			for(int i=0; i<upperBound; i++) {
				if(checkChasis.equals(vehicles[i].getChasisNo())){
					throw new DuplicateChasisException("Duplicate Entry Detected");
				}
			}
		}
		return checkChasis;
	}
}

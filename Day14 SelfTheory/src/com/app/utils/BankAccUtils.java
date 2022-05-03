package com.app.utils;

import java.time.LocalDate;
import java.util.HashMap;

import com.app.banking.BankAccount;
import static com.app.banking.AcType.*;


public class BankAccUtils {

	//static method to return populated map of accounts
	public static HashMap<Integer,BankAccount> populateAccMap(){
		//empty Map no need to write generic on rightSide
		HashMap<Integer, BankAccount> map = new HashMap<>();

		//adding k,v in map
		System.out.println("added " + map.put(101, new BankAccount(101,"Hardik", SAVINGS, LocalDate.parse("2020-05-03"),15000)));
		System.out.println("added " + map.put(10, new BankAccount(10,"Kamana", CURRENT, LocalDate.parse("2021-05-23"),7000)));
		System.out.println("added " + map.put(100, new BankAccount(100,"Udit", FD, LocalDate.parse("2020-09-29"),17000)));
		System.out.println("added " + map.put(11, new BankAccount(11,"Joy", DEMAT, LocalDate.parse("2020-03-23"),6700)));
		System.out.println("added " + map.put(56, new BankAccount(56,"Anita", LOAN, LocalDate.parse("2020-09-13"),9000)));

		//this will not retain old value
		//System.out.println("added " + map.put(101, new BankAccount(101,"Agarwal", SAVINGS, LocalDate.parse("2020-05-03"),15000)));

		//this will retain
		System.out.println("added " + map.putIfAbsent(101, new BankAccount(101,"Agarwal", SAVINGS, LocalDate.parse("2020-05-03"),15000)));

		System.out.println("Size of Map: " + map.size());
		return map;
	}
}

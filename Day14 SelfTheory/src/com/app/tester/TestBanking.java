package com.app.tester;
import static com.app.utils.BankAccUtils.populateAccMap;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import com.app.banking.AcType;
import com.app.banking.BankAccount;
import com.app.exception.BankingException;
import com.app.utils.BankingValidationRules;

public class TestBanking {

	public static void main(String[] args) {

		try(Scanner scan = new Scanner(System.in)){
			//populates a hash map
			HashMap<Integer,BankAccount> accountMap = populateAccMap();
			boolean exit = false;

			while(!exit) {
				System.out.println("Enter Choice:");
				System.out.println("1. Create A/c");
				System.out.println("2. Display All A/c");
				System.out.println("10. Exit");

				try{
					switch(Integer.parseInt(scan.nextLine())) {
						case 1:
								System.out.println("Enter A/c No:");
								int accNo = Integer.parseInt(scan.nextLine());
								if(accountMap.containsKey(accNo)) {
									throw new BankingException("Account Already Exist");
								}
								System.out.println("Enter A/c Details: customerName, accType, "
										+ "creationDate(yyyy-MM-dd), balance");
								accountMap.put(accNo, new BankAccount(accNo, scan.nextLine(), 
										AcType.valueOf(scan.nextLine().toUpperCase()), 
										LocalDate.parse(scan.nextLine()),
										BankingValidationRules.validateBalance(Double.parseDouble(scan.nextLine()))));
								System.out.println("A/c Added");
								break;
						case 2:
								System.out.println();
								break;
						case 10:
								exit = true;
								break;
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("HM" + accountMap);
		}
	}

}

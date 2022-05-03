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
				System.out.println("3. A/c Summary");
				System.out.println("4. Fund Transfer");
				System.out.println("10. Exit");

				try{
					switch(Integer.parseInt(scan.nextLine())) {
						case 1:
								System.out.println("Enter A/c No:");
								int accNo = Integer.parseInt(scan.nextLine());

								//containsKey will look for already existing or not 
								//avoiding duplicates
								if(accountMap.containsKey(accNo)) {
									throw new BankingException("Account Already Exist");
								}

								System.out.println("Enter A/c Details: customerName, accType, "
										+ "creationDate(yyyy-MM-dd), balance");
								accountMap.put(accNo, new BankAccount(accNo, scan.nextLine(), 
										AcType.valueOf(scan.nextLine().toUpperCase()), 
										LocalDate.parse(scan.nextLine()),
										BankingValidationRules.validateBalance(Double.parseDouble(scan.nextLine()))));

								System.out.println("A/c Added with a/c no: " + accNo);
								break;

						case 2: 
								System.out.println("All a/c in Bank:");
								for(BankAccount a: accountMap.values()) {
									System.out.println(a);
								}
								break;

						case 3:
								System.out.println("Enter A/c no:");

								//this method will directly get the value based on i/p key
								BankAccount acc = accountMap.get(Integer.parseInt(scan.nextLine()));
								if(acc == null) {
									throw new BankingException("Invalid a/c No!!!");
								}
								System.out.println("Bank A/c Summary: " + acc);
								break;

						case 4:
								System.out.println("Enter Source & Dest A/c No:");
								acc = accountMap.get(Integer.parseInt(scan.nextLine()));
								if(acc == null) {
									throw new BankingException("Invalid source a/c No!!!");
								}
								BankAccount destAcc = accountMap.get(Integer.parseInt(scan.nextLine()));
								if(destAcc == null) {
									throw new BankingException("Invalid dest a/c No!!!");
								}
								System.out.println("Enter Transfer Amount");
								acc.fundsTransfer(destAcc, Double.parseDouble(scan.nextLine()));
								break;

						case 5:
								System.out.println("Enter A/c no to close");

								//this method removes the key-value pair with passed key.
								acc = accountMap.remove(Integer.parseInt(scan.nextLine()));
								if(acc == null) {
									throw new BankingException("Invalid a/c No! Can't close a/c.");
								}
								System.out.println("Closed A/c: " + acc);
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

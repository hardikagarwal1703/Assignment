package com.app.tester;
import static com.app.utils.BankAccUtils.populateAccMap;

import java.util.HashMap;

import com.app.banking.BankAccount;

public class TestBanking {

	public static void main(String[] args) {

		//populates a hash map
		HashMap<Integer,BankAccount> accountMap = populateAccMap();
		System.out.println("HM" + accountMap);

		

	}

}

package com.app.utils;

import com.app.exception.BankingException;

public class BankingValidationRules {
	public static final double MIN_BALANCE;
	static {
		MIN_BALANCE = 5000;
	}

	public static double validateBalance(double bal) throws BankingException{
		if(bal<MIN_BALANCE) {
			throw new BankingException("Minimum Balance Reached!");
		}
		return bal;
	}
}

package com.app.exception;

@SuppressWarnings("serial")
public class BankingException extends Exception{
	public BankingException(String message) {
		super(message);
	}
}

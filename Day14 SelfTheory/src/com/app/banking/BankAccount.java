package com.app.banking;

import java.time.LocalDate;

import com.app.exception.BankingException;
import static com.app.utils.BankingValidationRules.validateBalance;

public class BankAccount {
	private int accNo;
	private String customerName;
	private AcType accType;

	private LocalDate creationDate;	
	//wrapper for holding date yyyy-MM-dd, immutable
	//no SimpleDateFormat required for parsing or formatting.

	private double balance;
	public BankAccount(int accNo, String customerName, AcType accType, LocalDate creationDate, double balance) {
		super();
		this.accNo = accNo;
		this.customerName = customerName;
		this.accType = accType;
		this.creationDate = creationDate;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", customerName=" + customerName + ", accType=" + accType
				+ ", creationDate=" + creationDate + ", balance=" + balance + "]";
	}

	//If you want to add account info in HashMap,
	//method to override = none (neither equals nor hashcode())
	//since key type of map is java.lang.Integer which is already 
	//following contract

	//here HM<Integer,BankAccount>

	//if we would have added composite primary key then 
	//then, HM<AccountPK,BankAccount>

	public void deposit(double amount) {
		this.balance += amount;
	}

	public void withdraw(double amount) throws BankingException{
		validateBalance(this.balance-amount);
		this.balance -= amount;
	}

	public void fundsTransfer(BankAccount dest, double transferAmt) throws BankingException{
		this.withdraw(transferAmt);
		dest.deposit(transferAmt);
		System.out.println("Funds Transferred from src: " + this.accNo 
				+ " to dest: " + dest.accNo);
	}
}

package com.app.banking;

import java.time.LocalDate;

public class BankAccount {
	private int accNo;
	private String customerName;
	private AcType accType;
	private LocalDate creationDate;	//wrapper for holding date yyyy-MM-dd, immutable
}

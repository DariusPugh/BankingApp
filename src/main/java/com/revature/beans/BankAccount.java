package com.revature.beans;

import java.io.Serializable;
import java.net.Authenticator;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6481590061326959654L;
	private static int numberOfAccounts = 0;
	private int accountNumber;
	private String accountName;
	private double balance;
	private LocalDateTime creationDate;
	private NumberFormat doubleFormatter = new DecimalFormat("#0.00");
	
	public BankAccount (String accountName, Customer primaryUser) {
		//super();
		numberOfAccounts++;
		this.accountNumber = numberOfAccounts;
		this.accountName = accountName;
		this.balance = 0;
		this.creationDate = LocalDateTime.now();
		//primaryUser.addAccount(this);
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}


	public NumberFormat getDoubleFormatter() {
		return doubleFormatter;
	}

	public void setDoubleFormatter(NumberFormat doubleFormatter) {
		this.doubleFormatter = doubleFormatter;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", accountName=" + accountName + ", balance=" + balance
				+ ", creationDate=" + creationDate + "]";
	}
	
	
}


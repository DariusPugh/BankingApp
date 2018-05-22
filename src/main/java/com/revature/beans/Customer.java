package com.revature.beans;

import java.io.Serializable;


import java.time.LocalDateTime;



public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2315367606751376445L	;
	
	private String userID;
	private String password;
	private String firstName;
	private String lastName;
	private BankAccount userAccount;
	private LocalDateTime timeJoined;
	
	
	public Customer(String firstName, String lastName, String userID, String password, BankAccount userAccount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userID = userID;
		this.password = password;
		this.userAccount = new BankAccount(userID, this);
		this.timeJoined = LocalDateTime.now();
	}

	
	
	public String getUserID() {
		return userID;
	}



	public void setUserID(String userID) {
		this.userID = userID;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public BankAccount getCusAccount() {
		return userAccount;
	}



	public void setCusAccount(BankAccount cusAccount) {
		this.userAccount = cusAccount;
	}



	public LocalDateTime getTimeJoined() {
		return timeJoined;
	}



	public void setTimeJoined(LocalDateTime timeJoined) {
		this.timeJoined = timeJoined;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Customer [userID=" + userID + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", userAccount=" + userAccount + ", timeJoined=" + timeJoined + "]";
	}


	



	

	
	
}
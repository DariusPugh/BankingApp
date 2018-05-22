package com.revature.beans;

public class Admin extends Customer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6360728739086701701L;
	private static int adminNumber = 1000000;
	private String employeeID;

	public Admin(String firstName, String lastName, String cusAccount, String password) {
		super(firstName, lastName, cusAccount, password, null);
		// TODO Auto-generated constructor stub
	}

	public static int getAdminNumber() {
		return adminNumber;
	}

	public static void setAdminNumber(int adminNumber) {
		Admin.adminNumber = adminNumber;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	
	
}

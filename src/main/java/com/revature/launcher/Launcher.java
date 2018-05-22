package com.revature.launcher;

import com.revature.beans.Customer;
import com.revature.prompt.LoginPrompt;
import com.revature.prompt.Prompt;

public class Launcher {
	private static Customer myAccount;
	public static Customer GetCustomer() {
		return myAccount;
	}
	public static void myAccount(Customer customer) {
		myAccount = customer;
	}
	
	public static void main(String[] args) {
		Prompt currentPromp = new LoginPrompt();
		while(true) {
			currentPromp = currentPromp.run();
		}
	}

}

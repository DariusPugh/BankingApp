package com.revature.prompt;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerSerializer;
import com.revature.launcher.Launcher;

public class LoginPrompt implements Prompt {
	
	private Scanner scan = new Scanner(System.in);
	private CustomerDao customerDao = new CustomerSerializer();
	
	public Prompt run() {
			System.out.println("Welcome to SUPERBANKER\nIf you would like to register as a new "
					+ "user please enter '1'\n"
					+ "If you would like to log in, please enter '2' ");
			
			String input = scan.nextLine();
			
			switch (input) {
			case "1":
				try {
					System.out.println("Please enter your first name: ");
					String firstName = scan.nextLine();
					System.out.println("Please enter your last name: ");
					String lastName = scan.nextLine();
					System.out.println("Please enter your userID: ");
					String userID = scan.nextLine();
					System.out.println("Please enter your password: ");
					String password = scan.nextLine();
					
					Customer newCustomer = new Customer(firstName, lastName, userID, password, null);
					customerDao.saveCustomer(newCustomer);
					
					System.out.println("You have are now registered");
					return new LoginPrompt();
				} catch (NoSuchElementException e) {
					System.out.println("Incorrect username or password, Please try again.");
					return this;
				}
				
				
			case "2":
			try {
				System.out.println("Please enter userID");
				String checkUserID = scan.nextLine();
				System.out.println("Please enter Password: ");
				String checkUserPassword = scan.nextLine();
				Customer target = customerDao.findAll().stream().filter(o -> o.getUserID().equals(checkUserID)).findFirst().get();
				String targetID = target.getUserID();
				String targetPass = target.getPassword();
				//System.out.println(customerDao.findAll());
				if(checkUserID.equals(targetID) && 
						checkUserPassword.equals(targetPass)) {
					
					return new MainMenuPrompt();
				}
			}
			catch (NoSuchElementException e) {
				System.out.println("Incorrect Username and/or Password, Please try again.");
				return this;
			}
			catch (NullPointerException e) {
				System.out.println("Incorrect Username or Password, Please try again.");
				return this;
			}
			default: System.out.println("Invalid Input, Please Try Again");
				return this;
			}
	}
}

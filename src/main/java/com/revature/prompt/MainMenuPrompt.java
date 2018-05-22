package com.revature.prompt;

import java.util.List;
import java.util.Scanner;

import com.revature.beans.BankAccount;
import com.revature.beans.Customer;
import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerSerializer;
import com.revature.launcher.Launcher;


public class MainMenuPrompt implements Prompt {
	private CustomerDao customerDao = new CustomerSerializer();
	@Override
	public Prompt run() {
		System.out.println("Enter 1 to view Account Balance");
		System.out.println("Enter 2 to make a Withdraw");
		System.out.println("Enter 3 to make a Deposit");
		System.out.println("Enter 4 to view Transaction History");
		System.out.println("Enter 5 to Log Out");
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		double x;
		double y;
		System.out.println("Please enter userID");
		String checkUserID = scan.nextLine();
		System.out.println("Please enter Password: ");
		String checkUserPassword = scan.nextLine();
		Customer target = customerDao.findAll().stream().filter(o -> o.getUserID().equals(checkUserID)).findFirst().get();
		
		switch (input) {
		case "1":
			System.out.println("Your bank account balance is: " + target.getCusAccount().getBalance());
			return new MainMenuPrompt();
			
		case "2":
			System.out.println("Please enter withdraw amount: ");
			String amount = scan.nextLine();
			y = Double.parseDouble(amount);
			double targetBalance = target.getCusAccount().getBalance();
			double balance = targetBalance;
			double oldBalance = balance;
			if(oldBalance >= y) {
				x = balance - y;
				target.getCusAccount().setBalance(x);
				if(oldBalance != target.getCusAccount().getBalance()) {
					customerDao.saveTransaction(target.getCusAccount().getBalance());
				}
			}
			else
				System.out.println("Withdraw Amount Exeeds Balance");
			
			return this;
			
		case "3":
			System.out.println("Please enter deposit amount: ");
			String amount2 = scan.nextLine();
			y = Double.parseDouble(amount2);
			System.out.println(y);
			targetBalance = target.getCusAccount().getBalance();
			double balance2 = targetBalance;
			System.out.println(balance2);
			System.out.println(targetBalance);
			double oldBalance2 = balance2;
			System.out.println(oldBalance2);
			x = oldBalance2 + y;
			target.getCusAccount().setBalance(x);
			System.out.println(target.getCusAccount().getBalance());
			
			if(oldBalance2 != target.getCusAccount().getBalance() ) {
				//System.out.println("Print Balance: " + target);
				targetBalance = target.getCusAccount().getBalance();
				customerDao.saveTransaction(targetBalance);
				}

			return this;
			
		case "4":
			System.out.println("Transaction History as follows: " +
			customerDao.findAll());
			return new MainMenuPrompt();
			
		case "5":
			return new LoginPrompt();

		default:
			System.out.println("Invalid Character");
			return new MainMenuPrompt();
		}
	}
	

}

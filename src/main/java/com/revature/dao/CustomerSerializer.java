package com.revature.dao;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Customer;

public class CustomerSerializer implements CustomerDao {
	private final String FILE_LOCATION = "src/main/resources/customers.txt";
	Scanner scan = new Scanner(System.in);


	@Override
	public boolean saveTransaction(Customer b) {
		try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(FILE_LOCATION))) {

			outStream.writeObject(Double.valueOf(b.getCusAccount().getBalance())); 
			return true;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;

	}

	public boolean saveCustomer(Customer b) {
		List<Customer> currentCustomers = findAll();
		if (currentCustomers == null) {
			currentCustomers = new ArrayList<>();
		}
	    currentCustomers.add(b);
	    
	    try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(FILE_LOCATION))) {

			outStream.writeObject(currentCustomers); // serialize the list to the file
			return true;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Customer> findAll() {
		try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(FILE_LOCATION))) {

			return (List<Customer>) inStream.readObject();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean saveTransaction(double d) {
		// TODO Auto-generated method stub
		return false;
	}


}

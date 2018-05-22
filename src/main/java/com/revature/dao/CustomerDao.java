package com.revature.dao;

import java.util.List;

import com.revature.beans.Customer;

public interface CustomerDao {

	boolean saveTransaction(double d);
	boolean saveCustomer(Customer b);

	List<Customer> findAll();
	
	boolean saveTransaction(Customer b);
	
}

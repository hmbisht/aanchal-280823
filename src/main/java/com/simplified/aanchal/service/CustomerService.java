package com.simplified.aanchal.service;

import java.util.List;

import com.simplified.aanchal.connectors.db.Customer;

public interface CustomerService {
	

	List<Customer> get();
	
	Customer get(int id);
	
	void save(Customer customer);
	
	void delete(int id);

	Customer update(int id, Customer customer);
	

}

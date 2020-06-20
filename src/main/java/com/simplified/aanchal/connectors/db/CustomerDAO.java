package com.simplified.aanchal.connectors.db;

import java.util.List;

public interface CustomerDAO {
	
	List<Customer> findAll();
	
	Customer findById(int id);
	
	void save(Customer customer);
	
	void deleteById(int id);
	

}

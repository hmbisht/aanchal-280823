package com.simplified.aanchal.connectors.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}

	@Override
	public Customer findById(int id) {
		return customerRepository.findById(id);
	}

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void deleteById(int id) {
		customerRepository.deleteById(id);

	}

}

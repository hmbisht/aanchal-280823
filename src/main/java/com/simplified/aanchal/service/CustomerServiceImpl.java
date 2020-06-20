package com.simplified.aanchal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplified.aanchal.connectors.db.CustomerDAO;
import com.simplified.aanchal.connectors.db.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDao;

	@Transactional
	@Override
	public List<Customer> get() {
		return customerDao.findAll();
	}

	@Transactional
	@Override
	public Customer get(int id) {
		return customerDao.findById(id);
	}

	@Transactional
	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	@Transactional
	@Override
	public void delete(int id) {
		customerDao.deleteById(id);
	}

	@Transactional
	@Override
	public Customer update(int id, Customer customer) {
		Customer c = customerDao.findById(id);
		if (null == c) {
			customerDao.save(customer);
			return customer;
		} else {
			c.setName(customer.getName());
			c.setGender(customer.getGender());
			customerDao.save(c);
			return c;
		}
	}

}

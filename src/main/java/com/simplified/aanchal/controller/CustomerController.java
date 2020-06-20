package com.simplified.aanchal.controller;

import java.util.List;

import com.simplified.aanchal.connectors.db.Customer;
import com.simplified.aanchal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:3000" })
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> get() {
		return customerService.get();
	}
	
	@PostMapping("/customers")
	public Customer save(@RequestBody Customer customer) {
		customerService.save(customer);
		return customer;
	}
	
	@GetMapping("/customers/{id}")
	public Customer get(@PathVariable int id) {
		return customerService.get(id);
	}
	
	@DeleteMapping("/customers/{id}")
	public String delete(@PathVariable int id) {
		customerService.delete(id);
		return "Customer removed with id " + id;
	}
	
	@PutMapping("/customers/{id}")
	public Customer update(@PathVariable int id, @RequestBody Customer customer) {
		return customerService.update(id, customer);
	}

}

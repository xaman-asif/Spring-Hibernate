package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	// need to inject our customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomers(@PathVariable int customerId) {
		Customer theCustomer = customerService.getCustomer(customerId);

		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}

		return theCustomer;
	}
	
	@PostMapping("/customers")
	public Customer saveCustomer(@RequestBody Customer theCustomer) {
		theCustomer.setId(0);

		customerService.saveCustomer(theCustomer);

		return theCustomer;
	}

	@PutMapping("/customers/{customerId}")
	public void saveCustomer(@PathVariable int customerId, @RequestBody Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
	}
	
	@DeleteMapping("/customers/{customerId}")
	public void deleteCustomer(@PathVariable("customerId") int theId) {
		customerService.deleteCustomer(theId);
	}
	
	@GetMapping("/search")
	public List<Customer> searchCustomers(@RequestParam("theSearchName") String theSearchName) {
		List<Customer> theCustomers = customerService.searchCustomers(theSearchName);

		return theCustomers;
	}
}

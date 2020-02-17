package com.example.api.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.api.domain.Customer;
import com.example.api.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@GetMapping
	public List<Customer> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Customer findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
	}
	
	@DeleteMapping
	public void deleteCustomer(@PathVariable Customer c) {
		service.delete(c);
	}
	
	@PostMapping
	public ResponseEntity<?> createCustomer(@RequestBody Customer c) {
		if(c.getName() != null || c.getEmail() != null)	
			return ResponseEntity.ok(service.save(c));
		else
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PutMapping
	public  ResponseEntity<?> updateCustomer(@RequestBody Customer c) {
		if(c.getName() != null || c.getEmail() != null)	
			return ResponseEntity.ok(service.save(c));
		else
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
	}
	
}

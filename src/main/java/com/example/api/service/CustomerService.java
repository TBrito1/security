package com.example.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.api.domain.Customer;
import com.example.api.domain.Endereco;
import com.example.api.helper.StringHelper;
import com.example.api.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository repository;

	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public List<Customer> findAll(Pageable pageable) {
		return repository.findAllByOrderByNameAsc(pageable);
	}

	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}

	public void delete(Customer c) {
		if(repository.findById(c.getId()).isPresent())
			repository.delete(c);
	}

	public Customer save(Customer c) {
		if(!StringHelper.isBlankOrNull(c.getName()) || !StringHelper.isBlankOrNull(c.getEmail())) {
			return repository.save(c);
		}else
			return new Customer();
	}

	public Customer update(Customer c) {
		if(!StringHelper.isBlankOrNull(c.getName()) || !StringHelper.isBlankOrNull(c.getEmail()))
			return repository.save(c);
		else
			return new Customer();
	}

}

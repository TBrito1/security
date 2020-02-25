package com.example.api.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.client.RestTemplate;

import com.example.api.domain.Customer;
import com.example.api.domain.Endereco;
import com.example.api.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	private EnderecoService service;

	@Autowired
	public EnderecoController(EnderecoService service) {
		this.service = service;
	}

	@GetMapping
	public List<Endereco> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Endereco findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco not found"));
	}

	@DeleteMapping
	public void deleteEndereco(@RequestBody Endereco e) {
		service.delete(e);
	}

	@PostMapping("/{cep}")
	public ResponseEntity<Endereco> createEndereco(@PathVariable Long cep) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			Endereco v = new Endereco();
			v = restTemplate.getForObject("viacep.com.br/ws/02420001/json/", Endereco.class);
		
			System.out.println(v);
			
			return ResponseEntity.ok(service.save(v));
		}catch (Exception exp) {
			return new ResponseEntity<Endereco> (HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PutMapping
	public  ResponseEntity<?> updateEndereco(@RequestBody Endereco e) {
		try {
			service.findById(e.getId())
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco not found"));
			return ResponseEntity.ok(service.update(e));
		}catch (Exception exp) {
			return new ResponseEntity<Customer> (HttpStatus.NOT_ACCEPTABLE);
		}
	}
}

package com.example.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.domain.Endereco;
import com.example.api.repository.EnderecoRepository;

@Service
public class EnderecoService {

	private EnderecoRepository repository;

	@Autowired
	public EnderecoService(EnderecoRepository repository) {
		this.repository = repository;
	}

	public List<Endereco> findAll() {
		return repository.findAll();
	}

	public Optional<Endereco> findById(Long id) {
		return repository.findById(id);
	}

	public void delete(Endereco e) {
		repository.delete(e);
	}

	public Endereco save(Endereco e) {
		return repository.save(e);
	}

	public Endereco update(Endereco e) {
		return repository.save(e);
	}
}

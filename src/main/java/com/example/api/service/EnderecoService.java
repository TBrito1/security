package com.example.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.domain.Endereco;
import com.example.api.repository.EnderecoRepository;

@Service
public class EnderecoService {

	private EnderecoRepository enderecoRepository;

	@Autowired
	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}

	public Optional<Endereco> findById(Long id) {
		return enderecoRepository.findById(id);
	}

	public void delete(Endereco e) {
		enderecoRepository.delete(e);
	}

	public Endereco save(Endereco e) {
		return enderecoRepository.save(e);
	}

	public Endereco update(Endereco e) {
		return enderecoRepository.save(e);
	}
}

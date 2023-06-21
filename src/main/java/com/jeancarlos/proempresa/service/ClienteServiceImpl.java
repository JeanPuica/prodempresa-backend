package com.jeancarlos.proempresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeancarlos.proempresa.model.Cliente;
import com.jeancarlos.proempresa.repo.IClienteRepo;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepo repository;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}

}

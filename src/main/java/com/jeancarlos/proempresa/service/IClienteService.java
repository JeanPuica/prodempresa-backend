package com.jeancarlos.proempresa.service;

import java.util.List;

import com.jeancarlos.proempresa.model.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();

	public Cliente save(Cliente nuevoCliente);

	public Cliente findOne(Long id);

	public void delete(Long id);

}

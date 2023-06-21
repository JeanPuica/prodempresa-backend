package com.jeancarlos.proempresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeancarlos.proempresa.handler.BadException;
import com.jeancarlos.proempresa.model.Cliente;
import com.jeancarlos.proempresa.service.IClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private IClienteService service;

	@GetMapping()
	public List<Cliente> getAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Cliente getOne(@PathVariable Long id) {
		return service.findOne(id);
	}

	@PostMapping()
	public Cliente insert(@RequestBody Cliente nuevoCliente) {
		return service.save(nuevoCliente);
	}

	@PutMapping("/{id}")
	public Cliente update(@RequestBody Cliente clientData, @PathVariable Long id) throws BadException {
		Cliente cliente = service.findOne(id);

		if (cliente == null) {
			throw new BadException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
		}

		clientData.setId(id);
		clientData.setCreateAt(cliente.getCreateAt());

		return service.save(clientData);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}

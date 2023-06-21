package com.jeancarlos.proempresa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeancarlos.proempresa.model.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Long> {
}
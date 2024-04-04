package io.github.alextonycloud.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.alextonycloud.clientes.model.entity.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{

}

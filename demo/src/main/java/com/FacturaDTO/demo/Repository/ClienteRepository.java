package com.FacturaDTO.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.FacturaDTO.demo.Repository.Entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Cliente findByEmail(String email);
}

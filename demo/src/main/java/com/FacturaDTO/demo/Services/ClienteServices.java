package com.FacturaDTO.demo.Services;

import java.util.List;

import com.FacturaDTO.demo.Repository.Entities.Cliente;

public interface ClienteServices {
    
    Cliente save(Cliente cliente);

    List<Cliente> findAll();

    void deleteById(Long id);

    Cliente findById(Long id);

    Cliente update(Long id,Cliente cliente);
}

package com.FacturaDTO.demo.Services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FacturaDTO.demo.Repository.ClienteRepository;
import com.FacturaDTO.demo.Repository.Entities.Cliente;
import com.FacturaDTO.demo.Services.ClienteServices;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ClienteImplServices implements ClienteServices {

    private ClienteRepository clienteRepository;

    @Override
    @Transactional
    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Override

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }


    @Override
    public Cliente update(Long id, Cliente cliente) {
       Optional<Cliente> clienteCurrentOptional = clienteRepository.findById(id);

       if(clienteCurrentOptional.isPresent()){
          Cliente clienteCurrent=clienteCurrentOptional.get();
          clienteCurrent.setNombre(cliente.getNombre());
          clienteCurrent.setApellido(cliente.getApellido());
          clienteCurrent.setEmail(cliente.getEmail()); 
          clienteRepository.save(clienteCurrent);
          return clienteCurrent;         
       }

       return null;
       
       
    }

    @Override
    public void deleteById(Long id){
        clienteRepository.deleteById(id);
    }

}

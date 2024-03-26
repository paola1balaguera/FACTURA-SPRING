package com.FacturaDTO.demo.Services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.FacturaDTO.demo.Repository.FacturaRepository;
import com.FacturaDTO.demo.Repository.Entities.Factura;
import com.FacturaDTO.demo.Services.FacturaServices;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class FacturaImplServices implements FacturaServices {
    
    private FacturaRepository facturaRepository;


    @Override
    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }


    @Override
    public Factura findById(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Factura> findAll() {
        return (List<Factura>) facturaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        facturaRepository.deleteById(id);
    }
}

package com.FacturaDTO.demo.Services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.FacturaDTO.demo.Repository.ProductoRepository;
import com.FacturaDTO.demo.Repository.Entities.Producto;
import com.FacturaDTO.demo.Services.ProductoServices;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductoImplServices implements ProductoServices {
    
    private ProductoRepository productoRepository;

    @Override
    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> findAll(){
        
        return (List<Producto>) productoRepository.findAll();
    }

    @Override 
    public void deleteById(Long id){
        productoRepository.deleteById(id);
    }


}

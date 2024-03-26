package com.FacturaDTO.demo.Services;

import java.util.List;

import com.FacturaDTO.demo.Repository.Entities.Producto;

public interface ProductoServices {
    
    Producto save(Producto producto);

    List<Producto> findAll();

    void deleteById(Long id);
}

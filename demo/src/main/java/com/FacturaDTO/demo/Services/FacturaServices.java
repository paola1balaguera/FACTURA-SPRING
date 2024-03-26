package com.FacturaDTO.demo.Services;

import java.util.List;



import com.FacturaDTO.demo.Repository.Entities.Factura;




public interface FacturaServices {
    
    Factura save(Factura factura);

    List<Factura> findAll();

    void deleteById(Long id);

    Factura findById(Long id);
}

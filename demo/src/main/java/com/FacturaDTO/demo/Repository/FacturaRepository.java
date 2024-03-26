package com.FacturaDTO.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.FacturaDTO.demo.Repository.Entities.Factura;

public interface FacturaRepository extends CrudRepository<Factura, Long>{

    
}

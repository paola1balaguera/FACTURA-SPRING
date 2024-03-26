package com.FacturaDTO.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.FacturaDTO.demo.Repository.Entities.ItemFactura;

public interface ItemFacturaRepository extends CrudRepository<ItemFactura, Long> {
    
}

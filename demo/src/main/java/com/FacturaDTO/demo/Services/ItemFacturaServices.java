package com.FacturaDTO.demo.Services;

import java.util.List;

import com.FacturaDTO.demo.Repository.Entities.ItemFactura;

public interface ItemFacturaServices {
    
    ItemFactura save(ItemFactura itemFactura);

    List<ItemFactura> findAll();

    void deleteById(Long id);
}

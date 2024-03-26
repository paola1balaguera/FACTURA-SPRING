package com.FacturaDTO.demo.Services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.FacturaDTO.demo.Repository.ItemFacturaRepository;
import com.FacturaDTO.demo.Repository.Entities.ItemFactura;
import com.FacturaDTO.demo.Services.ItemFacturaServices;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ItemFacturaImplService implements ItemFacturaServices {
    
        private ItemFacturaRepository ItemfacturaRepository;


    @Override
    public ItemFactura save(ItemFactura itemfactura) {
        return ItemfacturaRepository.save(itemfactura);
    }

    @Override
    public List<ItemFactura> findAll() {
        
       return (List<ItemFactura>) ItemfacturaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        ItemfacturaRepository.deleteById(id);
    }
}

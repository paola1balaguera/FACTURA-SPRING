package com.FacturaDTO.demo.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FacturaDTO.demo.Repository.Entities.Factura;
import com.FacturaDTO.demo.Repository.Entities.ItemFactura;
import com.FacturaDTO.demo.Services.FacturaServices;
import com.FacturaDTO.demo.Services.ItemFacturaServices;

import lombok.AllArgsConstructor;



@RestController
@RequestMapping("/facturas")
@AllArgsConstructor

public class FacturaController {
    
    private FacturaServices facturaServices;
    private ItemFacturaServices itemFacturaServices;

    @GetMapping("/{id}")
    public Factura findById(@PathVariable Long id) {
        return facturaServices.findById(id);
    }

    
    @GetMapping("/")
    public List<Factura> findById() {
        return facturaServices.findAll();
    }

    @GetMapping("/find_all_item")
    public List<ItemFactura> findByIdItemFactura() {
        return itemFacturaServices.findAll();
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        facturaServices.deleteById(id);
    }

    @DeleteMapping("/{id}/item_factura")
    public void delete1(@PathVariable Long id){
        itemFacturaServices.deleteById(id);
    }
    @PostMapping("/")
    public Factura save(@RequestBody Factura factura){
        return facturaServices.save(factura);

    }

    @PostMapping("/item_factura")
    public ItemFactura save1(@RequestBody ItemFactura itemFactura){
        return itemFacturaServices.save(itemFactura);

    }
    
}

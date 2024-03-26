package com.FacturaDTO.demo.Repository.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item_factura")

public class ItemFactura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "facturas_id")
    @JsonBackReference //cuando yo liste el item no me traiga la factura
    private Factura factura;
    
    @ManyToOne()
    @JoinColumn(name = "productos_id")


/*     Many      To        One
    items               Producto
    id                  id
    id_producto         id_items
                        (mal) */

    private Producto producto;

    private Integer cantidad;
}

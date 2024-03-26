package com.FacturaDTO.demo.Repository.Entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facturas")

public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties(value = {"facturas", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    
/*     
    Debo usar estas relaciones para no tener que hacer consultas
    sql por ejemplo insert o SELECT y que el sistema reconozca las operaciones de 
    la bd desde el back desde mi sistema de back y no de la BD, aplica
    tambien pa cuando le pongo front, maneja por ejemplo esto como:
    private Cliente cliente; objeto permitiendo la maleabilidad de los datos 
    Recordar debate de 30 min con Mi amor Diego sobre pqe las relaciones    
*/

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    //Many        to        One
    //Factura               Cliente
    
    //Cliente             Factura
    //Id                  Id_cliente

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "factura")
    private List<ItemFactura> items;

/*     One           To         Many
    Factura                    Item

    Factura                    Item
    Id                         Id_factura
    (mal)
 */
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    private String descripcion;
    private String observacion;

}

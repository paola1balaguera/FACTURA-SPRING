package com.FacturaDTO.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.FacturaDTO.demo.Repository.Entities.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}

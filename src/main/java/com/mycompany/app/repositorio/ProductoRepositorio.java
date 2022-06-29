package com.mycompany.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.app.modelo.Producto;
@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{

}

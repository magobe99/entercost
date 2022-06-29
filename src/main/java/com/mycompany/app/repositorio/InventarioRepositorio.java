package com.mycompany.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.app.modelo.Inventario;
@Repository
public interface InventarioRepositorio extends JpaRepository<Inventario, Integer>{

}

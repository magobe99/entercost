package com.mycompany.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.app.modelo.Proveedor;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Integer>{
	
}

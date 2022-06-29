package com.mycompany.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.app.modelo.Compra;

@Repository
public interface CompraRepositorio extends JpaRepository<Compra, Integer>{

}

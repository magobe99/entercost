package com.mycompany.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.app.modelo.Pedido;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Integer>{

}

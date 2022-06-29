package com.mycompany.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.app.modelo.Pago;
@Repository
public interface PagoRepositorio extends JpaRepository<Pago, Integer>{

}

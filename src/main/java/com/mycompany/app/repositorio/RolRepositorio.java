package com.mycompany.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.app.modelo.Rol;
@Repository
public interface RolRepositorio extends JpaRepository<Rol, Integer>{

}

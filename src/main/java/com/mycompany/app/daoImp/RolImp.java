package com.mycompany.app.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.app.dao.RolServicio;
import com.mycompany.app.modelo.Rol;
import com.mycompany.app.repositorio.RolRepositorio;

@Service
public class RolImp implements RolServicio{
	@Autowired
	private RolRepositorio rolRepositorio;
	@Override
	public List<Rol> BuscarTodos() {
		
		return rolRepositorio.findAll();
	}

	@Override
	public void crearRol(Rol rol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarRol(Rol rol) {
		// TODO Auto-generated method stub
		
	}
	
	

}

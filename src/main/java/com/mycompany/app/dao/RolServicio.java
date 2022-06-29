package com.mycompany.app.dao;

import java.util.List;

import com.mycompany.app.modelo.Rol;

public interface RolServicio {
public List<Rol> BuscarTodos();
	
	public void crearRol(Rol rol);
		
	public void actualizarRol(Rol rol);
	
}

package com.mycompany.app.dao;

import java.util.List;

import com.mycompany.app.modelo.Proyecto;

public interface ProyectoServicio {
public List<Proyecto> Buscartodos();
	
	void crearProyecto(Proyecto proyecto);

	void actualizarProyecto(Proyecto proyecto);
	
	public void delete(int id);
	
	public Proyecto buscarById(int id);
}

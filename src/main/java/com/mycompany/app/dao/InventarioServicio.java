package com.mycompany.app.dao;

import java.util.List;


import com.mycompany.app.modelo.Inventario;



public interface InventarioServicio {
public List<Inventario> Buscartodos();
	
	public void crearInventario(Inventario inventario);
	
	public void actualizarInventario(Inventario inventario);
	
	public void delete(int id);
	
	 Inventario buscarById(int id);
	
}

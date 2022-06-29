package com.mycompany.app.dao;

import java.util.List;

import com.mycompany.app.modelo.Producto;


public interface ProductoServicio {
public List<Producto> Buscartodos();
	
	public void crearProducto(Producto producto);
	
	public void actualizarProducto(Producto producto);
	public void delete(int id);
	
	 Producto buscarById(int id);
}

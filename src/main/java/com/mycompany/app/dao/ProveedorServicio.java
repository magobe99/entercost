package com.mycompany.app.dao;

import java.util.List;


import com.mycompany.app.modelo.Proveedor;


public interface ProveedorServicio {
	public List<Proveedor> Buscar();
	
	void crearProveedor(Proveedor proveedor);

	void actualizarProveedor(Proveedor proveedor);
	
	public void delete(int id);
	
	 Proveedor buscarById(int id);
	 
	 public List<Proveedor> saveAll(List<Proveedor> listProveedor);
	

}

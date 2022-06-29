package com.mycompany.app.dao;

import java.util.List;

import com.mycompany.app.modelo.Compra;

public interface CompraServicio{
	public List<Compra> Buscartodos();
	
	public void crearCompra(Compra compra);
	
	public void actualizarCompra(Compra compra);
	
	public void delete(int id);
	
	Compra buscarById (int id);

}

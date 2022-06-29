package com.mycompany.app.dao;

import java.util.List;


import com.mycompany.app.modelo.Pedido;


public interface PedidoServicio {
public List<Pedido> Buscartodos();
	
	public void crearPedido(Pedido pedido);
	
	public void actualizarPedido(Pedido pedido);
	
	public void delete(int id);
	
	 Pedido buscarById(int id);
}

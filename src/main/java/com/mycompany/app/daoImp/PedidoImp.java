package com.mycompany.app.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.app.dao.PedidoServicio;
import com.mycompany.app.modelo.Pedido;
import com.mycompany.app.modelo.Proveedor;
import com.mycompany.app.repositorio.PedidoRepositorio;

@Service
public class PedidoImp implements PedidoServicio{
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	@Override
	public List<Pedido> Buscartodos() {
		
		return pedidoRepositorio.findAll() ;
	}

	@Override
	public void crearPedido(Pedido pedido) {
		int res=0;
		Pedido ped=pedidoRepositorio.save(pedido);
		if(!ped.equals(null)) {
			res=1;
		}
		
	}

	@Override
	public void actualizarPedido(Pedido pedido) {
		int res=0;
		Pedido ped=pedidoRepositorio.save(pedido);
		if(!ped.equals(null)) {
			res=1;
		}
		
	}

	@Override
	public void delete(int id) {
		
		 pedidoRepositorio.deleteById(id);
	}

	@Override
	public Pedido buscarById(int id) {
		
		return pedidoRepositorio.getById(id);
	}

}

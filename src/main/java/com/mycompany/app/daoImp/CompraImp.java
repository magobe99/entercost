package com.mycompany.app.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.app.dao.CompraServicio;
import com.mycompany.app.modelo.Compra;
import com.mycompany.app.repositorio.CompraRepositorio;
@Service
public class CompraImp implements CompraServicio{
	@Autowired
	private CompraRepositorio compraRepositorio;
	@Override
	public List<Compra> Buscartodos() {	
		
		return compraRepositorio.findAll();
	}

	@Override
	public void crearCompra(Compra compra) {
		int res=0;
		Compra pre=compraRepositorio.save(compra);
		if (!pre.equals(null)) {
			res = 1;
		}
		
	}

	@Override
	public void actualizarCompra(Compra compra) {
		int res=0;
		Compra pre=compraRepositorio.save(compra);
		if (!pre.equals(null)) {
			res = 1;
		}
				
	}

	@Override
	public void delete(int id) {
		compraRepositorio.deleteById(id);
	}

	@Override
	public Compra buscarById(int id) {
	
		return compraRepositorio.getById(id);
	}
		
}

package com.mycompany.app.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.app.dao.ProductoServicio;
import com.mycompany.app.modelo.Producto;
import com.mycompany.app.repositorio.ProductoRepositorio;

@Service
public class ProductoImp implements ProductoServicio{
	@Autowired
	private ProductoRepositorio productoRepositorio;
	@Override
	public List<Producto> Buscartodos() {
		
		return productoRepositorio.findAll();
	}

	@Override
	public void crearProducto(Producto producto) {
		int res=0;
		Producto produc=productoRepositorio.save(producto);
		if(!produc.equals(null)) {
			res=1;
		}
		
	}

	@Override
	public void actualizarProducto(Producto producto) {
		int res=0;
		Producto produc=productoRepositorio.save(producto);
		if(!produc.equals(null)) {
			res=1;
		}
		
	}

	@Override
	public void delete(int id) {
		
		productoRepositorio.deleteById(id);
	}

	@Override
	public Producto buscarById(int id) {
		
		return productoRepositorio.getById(id);
	}

}

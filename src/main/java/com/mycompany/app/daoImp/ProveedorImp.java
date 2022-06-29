package com.mycompany.app.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.app.dao.ProveedorServicio;
import com.mycompany.app.modelo.Proveedor;
import com.mycompany.app.repositorio.ProveedorRepositorio;

@Service

public class ProveedorImp implements ProveedorServicio{
	@Autowired
	private ProveedorRepositorio proveedorRepositorio;
	@Override
	public List<Proveedor> Buscar(){
		return proveedorRepositorio.findAll();
	}
	
	@Override
	public void crearProveedor(Proveedor proveedor) {
		int res=0;
		Proveedor pro=proveedorRepositorio.save(proveedor);
		if(!pro.equals(null)) {
			res=1;
		}
	}

	@Override
	public void actualizarProveedor (Proveedor proveedor) {
		int res=0;
		Proveedor pro=proveedorRepositorio.save(proveedor);
		if(!pro.equals(null)) {
			res=1;
		}
	}

	@Override
	public Proveedor buscarById(int id) {
	
		return proveedorRepositorio.getById(id);
	}

	@Override
	public void delete(int id) {
		 proveedorRepositorio.deleteById(id);
		
	}

	@Override
	public List<Proveedor> saveAll(List<Proveedor> listProveedor) {
		return this.proveedorRepositorio.saveAll(listProveedor);
	}
	
	
		

}

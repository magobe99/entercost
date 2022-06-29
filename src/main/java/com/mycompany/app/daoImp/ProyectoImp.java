package com.mycompany.app.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.app.dao.ProyectoServicio;
import com.mycompany.app.modelo.Proyecto;
import com.mycompany.app.repositorio.ProyectoRepositorio;

@Service
public class ProyectoImp implements ProyectoServicio{
	@Autowired
	private ProyectoRepositorio proyectoRepositorio;
	@Override
	public List<Proyecto> Buscartodos() {
		
		return proyectoRepositorio.findAll();
	}

	@Override
	public void crearProyecto(Proyecto proyecto) {
		int res=0;
		Proyecto proy=proyectoRepositorio.save(proyecto);
		if(!proy.equals(null)) {
			res=1;
		}
		
	}

	@Override
	public void actualizarProyecto(Proyecto proyecto) {
		int res=0;
		Proyecto proyec=proyectoRepositorio.save(proyecto);
		if(!proyec.equals(null)) {
			res=1;
		}
	}

	@Override
	public void delete(int id) {
				proyectoRepositorio.deleteById(id);
	}

	@Override
	public Proyecto buscarById(int id) {
		
		return proyectoRepositorio.getById(id);
	}
	
	
	

}

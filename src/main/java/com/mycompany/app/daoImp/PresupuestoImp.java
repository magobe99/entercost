package com.mycompany.app.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.app.dao.PresupuestoServicio;
import com.mycompany.app.modelo.Presupuesto;
import com.mycompany.app.repositorio.PresupuestoRepositorio;

@Service
public class PresupuestoImp implements PresupuestoServicio{
	@Autowired
	private PresupuestoRepositorio presupuestoRepositorio;
	@Override
	public List<Presupuesto> Buscartodos() {
		
		return presupuestoRepositorio.findAll();
	}

	@Override
	public void crearPresupuesto(Presupuesto presupuesto) {
		int res=0;
		Presupuesto pre=presupuestoRepositorio.save(presupuesto);
		if (!pre.equals(null)){
			res = 1;
		}
		
	}

	@Override
	public void actualizarPresupuesto(Presupuesto presupuesto) {
		int res=0;
		Presupuesto pre=presupuestoRepositorio.save(presupuesto);
		if (!pre.equals(null)){
			res = 1;
		}
		
	}

	@Override
	public void delete(int id) {
		presupuestoRepositorio.deleteById(id);
		
	}

	@Override
	public Presupuesto buscarById(int id) {
		
		return presupuestoRepositorio.getById(id);
	}

}
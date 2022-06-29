package com.mycompany.app.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.app.dao.PagoServicio;
import com.mycompany.app.modelo.Pago;
import com.mycompany.app.repositorio.PagoRepositorio;

@Service
public class PagoImp implements PagoServicio {

	@Autowired
	private PagoRepositorio pagoRepositorio;
	@Override
	public List<Pago> listarPago() {
		// TODO Auto-generated method stub
		return pagoRepositorio.findAll();
	}

	@Override
	public void crearPago(Pago pago) {
		int res=0;
		Pago pag = pagoRepositorio.save(pago);
		if(!pag.equals(null)) {
			res=1;
		}
		
	}

	@Override
	public void actualizarPago(Pago pago) {
		int res=0;
		Pago pag = pagoRepositorio.save(pago);
		if(!pag.equals(null)) {
			res=1;
		}
		
	}

	@Override
	public void delete(int id) {
		pagoRepositorio.deleteById(id);
		
	}

	@Override
	public Pago buscarById(int id) {
		
		return pagoRepositorio.getById(id);
	}

	@Override
	public List<Pago> saveAll(List<Pago> listPago) {
		
		return this.pagoRepositorio.saveAll(listPago);
	}
}
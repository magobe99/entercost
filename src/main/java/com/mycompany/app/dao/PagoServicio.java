package com.mycompany.app.dao;

import java.util.List;

import com.mycompany.app.modelo.Pago;


public interface PagoServicio {
public List<Pago> listarPago();
	
	public void crearPago(Pago Pago);
	
	public void actualizarPago(Pago Pago);
	
	public void delete(int id);
	
	Pago buscarById(int id);
	
	public List<Pago> saveAll(List<Pago> listPago);
}
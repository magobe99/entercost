package com.mycompany.app.dao;

import java.util.List;

import com.mycompany.app.modelo.Balance;

public interface BalanceServicio {
public List<Balance> Buscartodos();
	
	public void crearBalance(Balance balance);
	
	public void actualizarBalance(Balance balance);
	
	public void delete(int id);
	
	Balance buscarById(int id);
}
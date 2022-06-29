package com.mycompany.app.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.app.dao.BalanceServicio;
import com.mycompany.app.modelo.Balance;
import com.mycompany.app.repositorio.BalanceRepositorio;

@Service
public class BalanceImp implements BalanceServicio{
	@Autowired
	private BalanceRepositorio balanceRepositorio;
	@Override
	public List<Balance> Buscartodos() {
		
		return balanceRepositorio.findAll();
	}

	@Override
	public void crearBalance(Balance balance) {
		int res=0;
		Balance bal = balanceRepositorio.save(balance);
		if(!bal.equals(null)) {
			res=1;
		}
		
	}

	@Override
	public void actualizarBalance(Balance balance) {
		int res=0;
		Balance bal = balanceRepositorio.save(balance);
		if(!bal.equals(null)) {
			res=1;
		}
		
	}

	@Override
	public void delete(int id) {
		 balanceRepositorio.deleteById(id);
		
	}

	@Override
	public Balance buscarById(int id) {
		
		return balanceRepositorio.getById(id);
	}

}

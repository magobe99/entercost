package com.mycompany.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.app.daoImp.BalanceImp;
import com.mycompany.app.daoImp.CompraImp;
import com.mycompany.app.daoImp.PagoImp;
import com.mycompany.app.modelo.Balance;
import com.mycompany.app.modelo.Compra;
import com.mycompany.app.modelo.Pago;


@Controller
@RequestMapping
public class BalanceController {
	@Autowired
	BalanceImp balanceImp;
	@Autowired
	PagoImp pagoImp;
	@Autowired
	CompraImp compraImp;
	@GetMapping("/tablabalance")
	public String Listar(Model model) {
		List<Balance> listBalance = this.balanceImp.Buscartodos();
		model.addAttribute("listBalance", listBalance);
		return "tablabalance";
	}
	
	@GetMapping("/regbalance")
	public String CrearBalance(Model model) {
		model.addAttribute("balance", new Balance());
		List<Pago> listPago = this.pagoImp.listarPago();
		model.addAttribute("listPago", listPago);
		List<Compra> listCompra = this.compraImp.Buscartodos();
		model.addAttribute("listCompra", listCompra);
		return "regbalance";
	}
	
	@PostMapping("/guardarBalance")
	public String CrearBalance(@Valid Balance balance, BindingResult result, Model model, RedirectAttributes atributo) {
		if(result.hasErrors()) {
			List<Pago> listPago = this.pagoImp.listarPago();
			model.addAttribute("listPago", listPago);
			List<Compra> listCompra = this.compraImp.Buscartodos();
			model.addAttribute("listCompra", listCompra);
			return "/regbalance";
			
		}
		balanceImp.crearBalance(balance);
		atributo.addFlashAttribute("guardar", "Se ha registrado el balance con exito");
		return "redirect:/tablabalance";
	}
	
	@GetMapping("/modificarBalance")
	public String editarBalance(Balance balance, Model model) {
		Balance bal = new Balance();
		bal = balanceImp.buscarById(balance.getIdbalance());
		List<Pago> listPago = this.pagoImp.listarPago();
		model.addAttribute("balance", bal);
		model.addAttribute("listPago", listPago);
		List<Compra> listCompra = this.compraImp.Buscartodos();
		model.addAttribute("listCompra", listCompra);
		return "modificarbalance";
	}
	
	@PostMapping("/editarBalance")
	public String editar(@Valid Balance balance, Model model, RedirectAttributes atributo) {
		balanceImp.actualizarBalance(balance);
		List<Pago> listPago = this.pagoImp.listarPago();
		model.addAttribute("listPago", listPago);
		List<Compra> listCompra = this.compraImp.Buscartodos();
		model.addAttribute("listCompra", listCompra);
		atributo.addFlashAttribute("warning", "Se ha modificado el balance con exito");
		return "redirect:/tablabalance";
	}
	
	@GetMapping("/eliminarBalance/{id}")
	public String eliminarBalance(Model model, @PathVariable int id) {
		balanceImp.delete(id);
		List<Pago> listPago = this.pagoImp.listarPago();
		model.addAttribute("listPago", listPago);
		List<Compra> listCompra = this.compraImp.Buscartodos();
		model.addAttribute("listCompra", listCompra);
		return "redirect/tablabalance";
	}
}
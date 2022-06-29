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

import com.mycompany.app.daoImp.CompraImp;
import com.mycompany.app.daoImp.PagoImp;
import com.mycompany.app.daoImp.UsuarioImp;
import com.mycompany.app.modelo.Compra;
import com.mycompany.app.modelo.Pago;
import com.mycompany.app.modelo.Usuario;

@Controller
@RequestMapping
public class PagoController {

	@Autowired
	PagoImp pagoImp;
	@Autowired
	CompraImp compraImp;
	@Autowired
	UsuarioImp usuarioImp;
	
	@GetMapping("/tablapagos")
	public String Listar(Model model) {
		List<Pago>listPago = this.pagoImp.listarPago();
		model.addAttribute("listPago",listPago);
		return "tablapagos";
	}
	
	@GetMapping("/regpago")
	public String crearPago(Model model) {
		model.addAttribute("pago", new Pago());
		List<Compra> listCompra = this.compraImp.Buscartodos();
		model.addAttribute("listCompra", listCompra);
		List<Usuario> listUsuario = this.usuarioImp.BuscarTodos();
		model.addAttribute("listUsuario", listUsuario);
		return "regpago";
	}
	
	@PostMapping("/guardarPago")
	public String crearPago(@Valid Pago pago, BindingResult result, Model model, RedirectAttributes atributo) {
		if(result.hasErrors()) {
			List<Compra> listCompra = this.compraImp.Buscartodos();
			model.addAttribute("listCompra", listCompra);
			List<Usuario> listUsuario = this.usuarioImp.BuscarTodos();
			model.addAttribute("listUsuario", listUsuario);
			return "/regpago";
		}
		System.out.println("@@"+pago.isEstadopago());
		pagoImp.crearPago(pago);
		atributo.addFlashAttribute("guardar", "El pago se ha registradro con exito");
		return "redirect:/tablapagos";
	}
	
	@GetMapping("/modificarPago")
	public String editarPago(Pago pago, Model model) {
		Pago pag = new Pago();
		pag = pagoImp.buscarById(pago.getIdpago());
		model.addAttribute("pago", pag);
		List<Compra> listCompra = this.compraImp.Buscartodos();
		model.addAttribute("listCompra", listCompra);
		List<Usuario> listUsuario = this.usuarioImp.BuscarTodos();
		model.addAttribute("listUsuario", listUsuario);
		return "modificarpago";
	}
	
	@PostMapping("/editarPago")
	public String editar(@Valid Pago pago, Model model, RedirectAttributes atributo) {
		pagoImp.actualizarPago(pago);
		List<Compra> listCompra = this.compraImp.Buscartodos();
		model.addAttribute("listCompra", listCompra);
		List<Usuario> listUsuario = this.usuarioImp.BuscarTodos();
		model.addAttribute("listUsuario", listUsuario);
		atributo.addFlashAttribute("warning", "Se ha modificado el pago con exito");
		return "redirect:/tablapagos";
	}
	
	@GetMapping("/eliminarPago/{id}")
	public String delete(Model model, @PathVariable int id) {
		pagoImp.delete(id);
		return "redirect:/tablapagos";
	}
		
	
}
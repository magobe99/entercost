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
import com.mycompany.app.daoImp.PresupuestoImp;
import com.mycompany.app.daoImp.UsuarioImp;
import com.mycompany.app.modelo.Compra;
import com.mycompany.app.modelo.Presupuesto;
import com.mycompany.app.modelo.Usuario;


@Controller
@RequestMapping
public class CompraController {
	    @Autowired
		CompraImp compraImp;
	    @Autowired
	    PresupuestoImp presupuestoImp;
	    @Autowired
	    UsuarioImp usuarioImp;
		@GetMapping("/tablacompras")
		public String Listar(Model model) {
			List<Compra> listCompra = this.compraImp.Buscartodos();
			model.addAttribute("listCompra", listCompra);
			return "tablacompras";
		}
		
		@GetMapping ("/regcompras")
		public String crearCompra(Model model) {
			model.addAttribute("compra", new Compra());
			List<Presupuesto> listPresupuesto = this.presupuestoImp.Buscartodos();
			model.addAttribute("listPresupuesto", listPresupuesto);
			List<Usuario> listUsuario = this.usuarioImp.BuscarTodos();
			model.addAttribute("listUsuario", listUsuario);
			return "regcompras";
		}
		
		@PostMapping("/guardarCompra")
		public String crearCompra(@Valid Compra compra, BindingResult result, Model model, RedirectAttributes atributo) {
			if (result.hasErrors()) {
				List<Presupuesto> listPresupuesto = this.presupuestoImp.Buscartodos();
				model.addAttribute("listPresupuesto", listPresupuesto);
				List<Usuario> listUsuario = this.usuarioImp.BuscarTodos();
				model.addAttribute("listUsuario", listUsuario);
				return "regcompras";
			}
			compraImp.crearCompra(compra);
			atributo.addFlashAttribute("guardar", "Se ha reistrado la compra con exito!");
			return "redirect:/tablacompras";
		}
		
		@GetMapping ("/modificarCompra")
		public String editarCompra(Compra compra, Model model) {
			Compra pre = new Compra();
			pre = compraImp.buscarById(compra.getId());
			model.addAttribute("compra", pre);
			List<Presupuesto> listPresupuesto = this.presupuestoImp.Buscartodos();
			model.addAttribute("listPresupuesto", listPresupuesto);
			List<Usuario> listUsuario = this.usuarioImp.BuscarTodos();
			model.addAttribute("listUsuario", listUsuario);
			return "modificarcompra";
		}
		
		@PostMapping ("/editarCompra")
		public String editar(@Valid Compra compra, Model model, RedirectAttributes atributo) {
			compraImp.actualizarCompra(compra);
			List<Presupuesto> listPresupuesto = this.presupuestoImp.Buscartodos();
			model.addAttribute("listPresupuesto", listPresupuesto);
			List<Usuario> listUsuario = this.usuarioImp.BuscarTodos();
			model.addAttribute("listUsuario", listUsuario);
			atributo.addFlashAttribute("warning", "Se ha modificado la compra con exito");
			return "redirect:/tablacompras";
		}
		
		@GetMapping ("/eliminarCompra/{id}")
		public String delete(Model model, @PathVariable int id) {
			compraImp.delete(id);
			return "redirect:/tablacompras";
		}
		

}
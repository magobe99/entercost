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

import com.mycompany.app.daoImp.PresupuestoImp;
import com.mycompany.app.daoImp.ProyectoImp;
import com.mycompany.app.modelo.Presupuesto;
import com.mycompany.app.modelo.Proyecto;

@Controller
@RequestMapping
public class PresupuestoController {
	@Autowired
	PresupuestoImp presupuestoImp;
	@Autowired
	ProyectoImp proyectoImp;
	@GetMapping("/tablapresupuesto")
	public String Listar(Model model) {
		List<Presupuesto> listPresupuesto = this.presupuestoImp.Buscartodos();
		model.addAttribute("listPresupuesto",listPresupuesto);
		return "tablapresupuesto";
	}
	
	@GetMapping ("/regpresupuesto")
	public String crearPresupuesto(Model model) {
		model.addAttribute("presupuesto", new Presupuesto());
		List<Proyecto> listProyecto = this.proyectoImp.Buscartodos();
		model.addAttribute("listProyecto", listProyecto);
		return "regpresupuesto";
	}
	
	@PostMapping("/guardarPresupuesto")
	public String crearPresupuesto(@Valid Presupuesto presupuesto, BindingResult result, Model model, RedirectAttributes atributo) {
		if (result.hasErrors()) {
			List<Proyecto> listProyecto = this.proyectoImp.Buscartodos();
			model.addAttribute("listProyecto", listProyecto);
			return "regpresupuesto";
		}
		presupuestoImp.crearPresupuesto(presupuesto);
		atributo.addFlashAttribute("guardar", "Se ha registrado el presupuesto con exito");
		return "redirect:/tablapresupuesto";
	}
	
	@GetMapping ("/modificarPresupuesto")
	public String editarPresupuesto(Presupuesto presupuesto, Model model) {
		Presupuesto pre = new Presupuesto();
		pre = presupuestoImp.buscarById(presupuesto.getIdpresupuesto());
		model.addAttribute("presupuesto", pre);
		List<Proyecto> listProyecto = this.proyectoImp.Buscartodos();
		model.addAttribute("listProyecto", listProyecto);
		return "modificarpresupuesto";
	}
	
	@PostMapping ("/editarPresupuesto")
	public String editar(@Valid Presupuesto presupuesto, Model model, RedirectAttributes atributo) {
		presupuestoImp.actualizarPresupuesto(presupuesto);
		List<Proyecto> listProyecto = this.proyectoImp.Buscartodos();
		model.addAttribute("listProyecto", listProyecto);
		atributo.addFlashAttribute("warning", "Se ha modificado el presupuesto con exito");
		return "redirect:/tablapresupuesto";
	}
	
	@GetMapping ("/eliminarPresupuesto/{id}")
	public String delete(Model model, @PathVariable int id) {
		presupuestoImp.delete(id);
		return "redirect:/tablapresupuesto";
	}
	
	
}
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

import com.mycompany.app.modelo.Usuario;
import com.mycompany.app.daoImp.UsuarioImp;
import com.mycompany.app.daoImp.ProyectoImp;
import com.mycompany.app.modelo.Proyecto;


@Controller
@RequestMapping
public class ProyectoController {

	@Autowired
	ProyectoImp proyectoImp;
	@Autowired
	UsuarioImp usuarioImp;
	@GetMapping("/tablaproyecto")
	public String Listar(Model model) {
		List<Proyecto> listProyecto = this.proyectoImp.Buscartodos();
		model.addAttribute("listProyecto", listProyecto);
		return "tablaproyecto";
	}
	
	@GetMapping("/regproyecto")
    public String crearProyecto(Model model){
		model.addAttribute("proyecto",new Proyecto());
		List<Usuario> listUsuario = this.usuarioImp.BuscarTodos();
		model.addAttribute("listUsuario", listUsuario);
        return "regproyecto";  
     }
	
	
	@PostMapping("/guardarProyecto")
   public String crearProyecto(@Valid Proyecto proyecto, BindingResult result, Model model, RedirectAttributes attributes){
		if(result.hasErrors()) {
			List<Usuario> listUsuario = this.usuarioImp.BuscarTodos();
			model.addAttribute("listUsuario", listUsuario);
			return "regproyecto";
		}
		proyectoImp.crearProyecto(proyecto);
		attributes.addFlashAttribute("info", "Proyecto guardado con exito!");
       return "redirect:/tablaproyecto";
    }
	
	
	@GetMapping("/modificarproyecto")
	public String editar(Proyecto proyecto, Model model) {
	Proyecto pro = new Proyecto();
	pro=proyectoImp.buscarById(proyecto.getId());
	model.addAttribute("proyecto",pro);
	List<Usuario> listUsuario = this.usuarioImp.BuscarTodos();
	model.addAttribute("listUsuario", listUsuario);
		return "modificarproyecto";
	}
	
	
	@PostMapping("/editarproyecto")
    public String editarProyecto(@Valid Proyecto proyecto, Model model, RedirectAttributes attribute){
        proyectoImp.actualizarProyecto(proyecto);
        List<Usuario> listUsuario = this.usuarioImp.BuscarTodos();
		model.addAttribute("listUsuario", listUsuario);
		attribute.addFlashAttribute("warning", "Se ha modificado el proyecto con exito");
        return "redirect:/tablaproyecto";
    }
		
	
	@GetMapping("/eliminarProyecto/{id}")
		public String delete(Model model, @PathVariable int id) {
		proyectoImp.delete(id);
		return "redirect/tablaproyecto";
	}
}

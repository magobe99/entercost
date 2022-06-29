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

import com.mycompany.app.daoImp.InventarioImp;
import com.mycompany.app.daoImp.UsuarioImp;
import com.mycompany.app.modelo.Inventario;
import com.mycompany.app.modelo.Usuario;
import com.mycompany.app.repositorio.UsuarioRepositorio;

@Controller
@RequestMapping
public class InventarioController {
	
	
	@Autowired
	InventarioImp inventarioImp;
	@Autowired
	UsuarioImp usuarioImp;
	@Autowired
	UsuarioRepositorio usuarioRepositorio;

	@GetMapping("/tablainventario")
	public String Listar(Model model) {
		List<Inventario> listInventario = this.inventarioImp.Buscartodos();
		model.addAttribute("listInventario", listInventario);
		return "tablainventario";
	}


	@GetMapping("/regmaterial")
    public String crearInventario (Model model, Inventario inventario){
		model.addAttribute("inventario",new Inventario());
		List<Usuario> listUsuario = this.usuarioImp.BuscarTodos();
		model.addAttribute("listUsuario", listUsuario);
        return "regmaterial";
     }
	


	@PostMapping("/guardarMaterial")
   public String crearInventario(@Valid Inventario inventario, BindingResult result, Model model, RedirectAttributes attribute){
		if(result.hasErrors()) {
			List<Usuario> listUsuario = this.usuarioImp.BuscarTodos();
			model.addAttribute("listUsuario", listUsuario);
			return "regmaterial";
		}
		inventarioImp.crearInventario(inventario);
		attribute.addFlashAttribute("guardar", "Inventario guardado con exito");
       return "redirect:/tablainventario";
    }


	@GetMapping("/modificarinventario")
	public String editar(Inventario inventario, Model model) {
	Inventario inv = new Inventario();
	inv=inventarioImp.buscarById(inventario.getId());
	model.addAttribute("inventario",inv);
	List<Usuario> listUsuario = this.usuarioImp.BuscarTodos();
	model.addAttribute("listUsuario", listUsuario);
		return "modificarInventario";
	}


	@PostMapping("/editar")
    public String editarInventario(@Valid Inventario inventario, Model model, RedirectAttributes attribute){
        inventarioImp.actualizarInventario(inventario);
        List<Usuario> listUsuario = this.usuarioImp.BuscarTodos();
		model.addAttribute("listUsuario", listUsuario);
		attribute.addFlashAttribute("editar", "Inventario modificado con exito");
        return "redirect:/tablainventario";
    }


	@GetMapping("/eliminarInventario/{id}")
		public String delete(Model model, @PathVariable int id) {
		inventarioImp.delete(id);
		return "redirect/tablainventario";
	}

	
}

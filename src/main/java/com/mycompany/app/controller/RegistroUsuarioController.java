/*package com.mycompany.app.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.app.dao.UsuarioService;
import com.mycompany.app.daoImp.RolImp;
import com.mycompany.app.model.UsuarioRegistro;
import com.mycompany.app.modelo.Rol;
import com.mycompany.app.modelo.Usuario;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioController {
	
	@Autowired
	private UsuarioService  usuarioService;
	@Autowired
	RolImp rolImp;

	public RegistroUsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	@ModelAttribute("usuario")
	public UsuarioRegistro NuevoUsuario() {
		return new UsuarioRegistro();
	}
	
	@GetMapping
	public String FormularioNuevoUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		Collection<Rol> listRol = this.rolImp.BuscarTodos();
		model.addAttribute("listRol", listRol);
		return "formcrearcuenta";
	}
	
	@PostMapping
	public String GuardarUsuario(@ModelAttribute("usuario")@Valid UsuarioRegistro usuarioRegistro, RedirectAttributes atributo, BindingResult result) {
		if(result.hasErrors()) {
			return "formcrearcuenta";
		}
		usuarioService.guardar(usuarioRegistro);
		atributo.addFlashAttribute("guardar", "Se ha registrado el usuario con exito");
		return "tablausuario";
	}
	
}
*/
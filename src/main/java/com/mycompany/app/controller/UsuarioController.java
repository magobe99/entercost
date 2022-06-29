package com.mycompany.app.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.app.daoImp.RolImp;
import com.mycompany.app.daoImp.UsuarioImp;
import com.mycompany.app.modelo.Rol;
import com.mycompany.app.modelo.Usuario;


@Controller
@RequestMapping
public class UsuarioController {

	@Autowired
	UsuarioImp usuarioImp;
	@Autowired
	RolImp rolImp;
	@GetMapping("/tablausuario")
	public String Listar(Model model) {
		List<Usuario> listUsuario = this.usuarioImp.BuscarTodos();
		model.addAttribute("listUsuario", listUsuario);
		return "tablausuario";
	}
	
	@GetMapping("/eliminarUsuario/{id}")
	public String delete(Model model, @PathVariable int id) {
	usuarioImp.delete(id);
	return "redirect/tablausuario";
}

	/*
	@GetMapping("/registrarse")
    public String crearUsuario (Model model){
		model.addAttribute("usuario", new Usuario());
		List<Rol> listRol = this.rolImp.BuscarTodos();
		model.addAttribute("listRol", listRol);
        return "formcrearcuenta";  
     }
	
	@PostMapping("/guardarUsuario")
   public String crearUsuario(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes atributo){
		if(result.hasErrors()) {
			List<Rol> listRol = this.rolImp.BuscarTodos();
			model.addAttribute("listRol", listRol);
			return "formcrearcuenta";
		}
     usuarioImp.crearUsuario(usuario);
     atributo.addFlashAttribute("guardar", "Se ha registrado el usuario con exito");
       return "redirect:/registrarse";
    }*/
	
	@GetMapping("/modificarUsuario")
	public String modificarusuario(Usuario usuario, Model model) {
		Usuario usu = new Usuario();
		usu = usuarioImp.buscarByid(usuario.getId());
		model.addAttribute("usuario",usu);
		Collection<Rol> listRol = this.rolImp.BuscarTodos();
		model.addAttribute("listRol", listRol);
		return "modiusuario";
	}
	
	@PostMapping("/editarUsuario")
	public String editar(@Valid Usuario usuario, Model model, RedirectAttributes atributo) {
		usuarioImp.actualizarUsuario(usuario);
		Collection<Rol> listRol = this.rolImp.BuscarTodos();
		model.addAttribute("listRol", listRol);
		atributo.addFlashAttribute("warning", "Se ha modificado el pago con exito");
		return "redirect:/tablausuario";
	}

}

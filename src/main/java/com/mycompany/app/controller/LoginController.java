package com.mycompany.app.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.app.repositorio.UsuarioRepositorio;

@Controller
@RequestMapping
public class LoginController {
	
	
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	/*@GetMapping("/iniciar")
	public String login(@RequestParam(value="error", required=false)String error,
			Model model, Principal principal, RedirectAttributes flash) {
		
		if(principal != null) {
			flash.addFlashAttribute("info", "ya ha iniciado sesión anteriormente");
			//return "redirect:/";
		}
		
		if(error !=null) {
			model.addAttribute("error", "Error en el ingreso: Nombre o contraseña incorrecta, ingresar datos validos!");
		}
		return "login";
	}*/
	
	
	
	/*@GetMapping("/login")
    public String Login(@RequestParam(value = "error", required=false)String error, Usuario usuario, Principal principal,
    		@RequestParam(value = "logout", required=false)String logout, Model model,  RedirectAttributes attributes,
						@RequestParam(value = "invalid-session", defaultValue = "false")boolean invalidSession) {
		if(principal!= null) {
			attributes.addFlashAttribute("info", "Ya haz iniciado sesión");
			return "redirect:/";
		}
		
		if(error != null) {
			model.addAttribute("error", "Error en el login: Nombre o contraseña incorrecta, por favor vuelva a intentarlo");
		}
		
		if(logout !=null) {
			model.addAttribute("success", "Ha cerrado sesión correctamente!");
		}if(invalidSession) {

			model.addAttribute("invalid-session", "Session expirada, ingresa de nuevo por favor");
		}

        return "login";
    }*/
	
	@GetMapping("/login")
	public String login() {
		return "loginn";
	}

	@GetMapping("/administrador")
	public String Admin() {
		return "administrador";
	}

	@GetMapping("/inventario")
	public String Inventario() {
		return "inventario";
	}

	@GetMapping("/cartera")
	public String Cartera() {
		return "cartera";
	}

	@GetMapping("/caja")
	public String Caja() {
		return "caja";
	}

	@GetMapping("/dashboard")
	public  String dash(){
		return  "dash";
	}

	@GetMapping("/produccion")
	public String prod(){
		return  "prod";
	}

	@GetMapping("/inven")
	public String inven(){
		return  "inven";
	}

	
	
	
}

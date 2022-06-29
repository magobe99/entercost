package com.mycompany.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.app.daoImp.RolImp;

import com.mycompany.app.modelo.Rol;


@Controller
@RequestMapping
public class RolController {
	
	@Autowired
	RolImp rolImp;
	@GetMapping("/llllllllll")
	public String Listar(Model model) {
		List<Rol> listRol = this.rolImp.BuscarTodos();
		model.addAttribute("listRol", listRol);
		return "index";
	}
}

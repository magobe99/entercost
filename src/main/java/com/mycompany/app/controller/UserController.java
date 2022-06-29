package com.mycompany.app.controller;


import com.mycompany.app.dao.UsuarioService;
import com.mycompany.app.daoImp.RolImp;
import com.mycompany.app.model.UsuarioRegistroDTO;
import com.mycompany.app.modelo.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Collection;


@Controller
@RequestMapping("/registro")

public class UserController {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    private RolImp rolImp;

    @ModelAttribute("usuario")
    public  UsuarioRegistroDTO registroDTO(){

        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String formulario( Model model){
            Collection<Rol> listRol = this.rolImp.BuscarTodos();
            model.addAttribute("listRol", listRol);
        return "registrousuario";
    }

    @PostMapping
    public String registro(@ModelAttribute("usuario") @Valid  UsuarioRegistroDTO registroDTO, BindingResult result, Model model){
        if(result.hasErrors()) {
            Collection<Rol> listRol = this.rolImp.BuscarTodos();
            model.addAttribute("listRol", listRol);
            return "registrousuario";
        }
        usuarioService.guardar(registroDTO);
        return "redirect:/tablausuario";
    }


}

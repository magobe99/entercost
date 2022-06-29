package com.mycompany.app.dao;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.mycompany.app.model.UsuarioRegistroDTO;
import com.mycompany.app.modelo.Usuario;

public interface UsuarioService extends UserDetailsService{
		
		 Usuario guardar(UsuarioRegistroDTO registroDTO);

}

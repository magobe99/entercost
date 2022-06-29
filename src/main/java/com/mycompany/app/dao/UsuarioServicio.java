package com.mycompany.app.dao;

import java.util.List;

import com.mycompany.app.modelo.Usuario;

public interface UsuarioServicio {
	public List<Usuario> BuscarTodos();
	
	 void crearUsuario(Usuario usuario);
		
	void actualizarUsuario(Usuario usuario);
	
	public void delete(int id);
	
	 Usuario buscarByid(int id);
	 
	 
}

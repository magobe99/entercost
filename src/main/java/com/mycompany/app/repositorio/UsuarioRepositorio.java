package com.mycompany.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.app.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
	
	//public Usuario findByIdAndClave(Integer idusuario, String clave);

	//Usuario findByUsername(String nombreusuario);

	//Usuario findByUsername(String username);
	public Usuario findByEmail(String email);
	
	
	public Usuario findByResetPasswordToken(String token);

	
	
	
	
}

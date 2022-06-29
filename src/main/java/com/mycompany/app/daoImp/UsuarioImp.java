package com.mycompany.app.daoImp;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.app.dao.UsuarioServicio;
import com.mycompany.app.modelo.Usuario;
import com.mycompany.app.repositorio.UsuarioRepositorio;

@Service
@Transactional
public class UsuarioImp implements UsuarioServicio{
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	
	@Override
	public List<Usuario> BuscarTodos() {
		
		return usuarioRepositorio.findAll();
	}

	@Override
	public void crearUsuario(Usuario usuario) {
		Usuario usu=usuarioRepositorio.save(usuario);
		usuario.setPassword((usuario.getPassword()));
		int res=0;
		if(!usu.equals(null)) {
			res=1;
		}
		
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		int res=0;
		Usuario usu=usuarioRepositorio.save(usuario);
		if(!usu.equals(usu)) {
			res=1;
		}
	}
	
	@Override
	public Usuario buscarByid(int id) {
		return usuarioRepositorio.getById(id);	
	}

	@Override
	public void delete(int id) {
		usuarioRepositorio.deleteById(id);
		
	}

	
	public void updateResetPasswordToken(String token, String email) throws CustomerNotFoundException {
			Usuario usuario = usuarioRepositorio.findByEmail(email);
			
			if (usuario != null) {
				usuario.setResetPasswordToken(token);
				usuarioRepositorio.save(usuario);
			}else{
				throw new CustomerNotFoundException("No se pudo enviar no se reconoce correo " + email);
			}
	}
	
	public Usuario get(String resetPasswordToken) {
		return usuarioRepositorio.findByResetPasswordToken(resetPasswordToken);
	}
	
	public void updatePassword(Usuario usuario, String newPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(newPassword);
		
		usuario.setPassword(encodedPassword);
		usuario.setResetPasswordToken(null);
		
		usuarioRepositorio.save(usuario);
	}

	

}

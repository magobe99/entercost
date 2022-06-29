package com.mycompany.app.daoImp;


import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.app.dao.UsuarioService;
import com.mycompany.app.model.UsuarioRegistroDTO;
import com.mycompany.app.modelo.Rol;
import com.mycompany.app.modelo.Usuario;
import com.mycompany.app.repositorio.UsuarioRepositorio;

@Service
public class UsuarioRegistroImp implements UsuarioService{
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	private Usuario usuario;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Correo o contraseña no son correctos");
		}
		return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles())) ;
	}
		
	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
		return roles.stream().map(role -> new  SimpleGrantedAuthority(role.getNombrerol())).collect(Collectors.toList());
	}

	public boolean hasRole(String nombrerol){
		return this.usuario.hasRole(nombrerol);
	}


    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = new Usuario();
		usuario.setNombre(registroDTO.getNombre());
		usuario.setApellido(registroDTO.getApellido());
		usuario.setFechanacimiento(registroDTO.getFechanacimiento());
        usuario.setEdadusuario(registroDTO.getEdadusuario());
		usuario.setTelefonousuario(registroDTO.getTelefonousuario());
		usuario.setEmail(registroDTO.getEmail());
		usuario.setDireccionusuario(registroDTO.getDireccionusuario());
		usuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));
		usuario.setRoles(registroDTO.getRoles());
		Arrays.asList(new Rol().getNombrerol());
        return usuarioRepositorio.save(usuario);
    }
}

package com.mycompany.app.model;

import java.util.Collection;
import java.util.Date;


import com.mycompany.app.modelo.Rol;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


public class UsuarioRegistroDTO {

	private int id;

	private String nombre;

	private String apellido;

	@DateTimeFormat(iso = ISO.DATE)
	private Date fechanacimiento;

	private Integer edadusuario;

	private String telefonousuario;

	private String email;

	private String direccionusuario;
	
	private String password;
	

	
	private String resetPasswordToken;

	private Collection<Rol> roles;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public Integer getEdadusuario() {
		return edadusuario;
	}

	public void setEdadusuario(Integer edadusuario) {
		this.edadusuario = edadusuario;
	}

	public String getTelefonousuario() {
		return telefonousuario;
	}

	public void setTelefonousuario(String telefonousuario) {
		this.telefonousuario = telefonousuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccionusuario() {
		return direccionusuario;
	}

	public void setDireccionusuario(String direccionusuario) {
		this.direccionusuario = direccionusuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public UsuarioRegistroDTO(int id, String nombre, String apellido, Date fechanacimiento, Integer edadusuario, String telefonousuario, String email, String direccionusuario, String password, boolean permiso, String resetPasswordToken, Collection<Rol> roles) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanacimiento = fechanacimiento;
		this.edadusuario = edadusuario;
		this.telefonousuario = telefonousuario;
		this.email = email;
		this.direccionusuario = direccionusuario;
		this.password = password;

		this.resetPasswordToken = resetPasswordToken;
		this.roles = roles;
	}

	public UsuarioRegistroDTO(String nombre, String apellido, Date fechanacimiento, Integer edadusuario, String telefonousuario, String email, String direccionusuario, String password, boolean permiso, String resetPasswordToken, Collection<Rol> roles) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanacimiento = fechanacimiento;
		this.edadusuario = edadusuario;
		this.telefonousuario = telefonousuario;
		this.email = email;
		this.direccionusuario = direccionusuario;
		this.password = password;
		this.resetPasswordToken = resetPasswordToken;
		this.roles = roles;
	}

	public UsuarioRegistroDTO(String email) {
		super();
		this.email = email;
	}

	public UsuarioRegistroDTO() {
		super();
	}

	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}
	
	
}

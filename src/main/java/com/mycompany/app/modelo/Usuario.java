package com.mycompany.app.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.JoinColumn;
import lombok.Data;

@ToString
@Data
@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuario")
	private int id;
	@NotEmpty(message = "El nombre es obligatorio")
	@Column(name = "nombreusuario")
	private String nombre;
	@NotEmpty(message = "El apellido es obligatorio")
	@Column(name = "apellidousuario")
	private String apellido;
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fechanacimiento")
	private Date fechanacimiento;
	//@NotNull
	@Min(value = 18)
	@Column(name = "edadusuario")
	private Integer edadusuario;
	@NotEmpty(message = "El telefono es obligatorio")
	@Column(name = "telefono")
	private String telefonousuario;
	@Email
	@NotEmpty(message = "El correo es obligatorio")
	@Column(name = "email", unique=true)
	private String email;
	@NotEmpty(message = "La dirección es obligatoria")
	@Column(name = "direccionusuario")
	private String direccionusuario;
	@NotEmpty(message = "La contraseña es obligatoria")
	@Column(name = "clave")
	private String password;

	@Column(name = "reset_password_token")
	private String resetPasswordToken;

	@OneToMany(mappedBy = "usuario")
	private List<Compra> listCompra;

	@OneToMany(mappedBy = "usuario")
	private List<Proyecto> listProyecto;

	@OneToMany(mappedBy = "usuario")
	private List<Pago> listPago;

	@OneToMany(mappedBy = "usuario")
	private List<Inventario> listInventario;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_rol", joinColumns = {
			@JoinColumn(name = "idusuario", referencedColumnName = "idusuario") }, inverseJoinColumns = {
					@JoinColumn(name = "idrol", referencedColumnName = "idrol") })
	private Collection<Rol> roles;

	public boolean hasRole(String nombrerol){
		Iterator<Rol> iterator = this.roles.iterator();
		while (iterator.hasNext()){
			Rol rol = iterator.next();
			if (rol.getNombrerol().equals(nombrerol)){
				return true;
			}
		}
		return false;
	}
	public <T> Usuario(String nombre, String apellido, Date fechanacimiento, Integer edadusuario, String telefonousuario, String email, String direccionusuario, String password, List<T> asList) {
	}


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

	public List<Compra> getListCompra() {
		return listCompra;
	}

	public void setListCompra(List<Compra> listCompra) {
		this.listCompra = listCompra;
	}

	public List<Proyecto> getListProyecto() {
		return listProyecto;
	}

	public void setListProyecto(List<Proyecto> listProyecto) {
		this.listProyecto = listProyecto;
	}

	public List<Pago> getListPago() {
		return listPago;
	}

	public void setListPago(List<Pago> listPago) {
		this.listPago = listPago;
	}

	public List<Inventario> getListInventario() {
		return listInventario;
	}

	public void setListInventario(List<Inventario> listInventario) {
		this.listInventario = listInventario;
	}

	

	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}

	

	public Usuario(int id, @NotEmpty(message = "El nombre es obligatorio") String nombre,
			@NotEmpty(message = "El apellido es obligatorio") String apellido, @NotNull Date fechanacimiento,
			@NotNull @Min(18) Integer edadusuario,
			@NotEmpty(message = "El telefono es obligatorio") String telefonousuario,
			@Email @NotEmpty(message = "El correo es obligatorio") String email,
			@NotEmpty(message = "La dirección es obligatoria") String direccionusuario,
			@NotEmpty(message = "La contraseña es obligatoria") String password,
			String resetPasswordToken, List<Compra> listCompra, List<Proyecto> listProyecto,
			List<Pago> listPago, List<Inventario> listInventario, Collection<Rol> roles) {
		super();
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

		this.listCompra = listCompra;
		this.listProyecto = listProyecto;
		this.listPago = listPago;
		this.listInventario = listInventario;
		this.roles = roles;
	}
	
	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechanacimiento=" + fechanacimiento + ", edadusuario=" + edadusuario + ", telefonousuario="
				+ telefonousuario + ", email=" + email + ", direccionusuario=" + direccionusuario + ", password="
				+ password + ", resetPasswordToken=" + resetPasswordToken + ",  listCompra=" + listCompra + ", listProyecto=" + listProyecto + ", listPago=" + listPago
				+ ", listInventario=" + listInventario + ", roles=" + roles + "]";
	}

	public Usuario() {
		super();
	}

	

	
	
	
	
	
	
	
	

}

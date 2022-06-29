package com.mycompany.app.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
@Table(name="proveedor")
public class Proveedor implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idproveedor")
	private int id;
	@NotEmpty(message="El nombre del proveedor es obligatorio")
	@Column(name="nombreproveedor")
	private String nombre;
	@NotEmpty(message="El telefono del proveedor es obligatorio")
	@Column(name="telefonoproveedor")
	private String telefono;
	@NotEmpty(message="El correo del proveedor es obligatorio")
	@Email
	@Column(name="emailproveedor")
	private String correo;
	@NotEmpty(message="La dirección del proveedor es obligatorio")
	@Column(name="direccionproveedor")
	private String direccion;
	
	@ManyToMany
	   @JoinTable(name="compra_proveedor",
	           joinColumns={@JoinColumn(name="idproveedor",referencedColumnName="idproveedor")},
	          inverseJoinColumns = {@JoinColumn(name="idcompra",referencedColumnName="idcompra")})
	     private List<Compra> compras;
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}

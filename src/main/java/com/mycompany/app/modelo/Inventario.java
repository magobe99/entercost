package com.mycompany.app.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name="inventario")
public class Inventario implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idinventario")
	private int id;
	@NotEmpty(message="el campo nombre debe estar lleno")
	@Column(name="nombrematerial")
	private String nombre;
	@NotNull
	@Min(value=10)
	@Column(name="cantidadmaterial")
	private int cantidad;
	@NotEmpty(message="La categorial material esta vacio")
	@Column(name="categoria")
	private String categoria;
	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@FutureOrPresent
	@Column(name="fechaingreso")
	private LocalDate fechaingreso;
	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@FutureOrPresent
	@Column(name="fechasalida")
	private LocalDate fechasalida;
	
	@ManyToMany(mappedBy = "inventarios")
    private List<Producto> producto;
	
	@ManyToOne
	@JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    private Usuario usuario;
	
	public List<Producto> getProductos() {
		return producto;
	}
	public void setProductos(List<Producto> producto) {
		this.producto = producto;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public LocalDate getFechaingreso() {
		return fechaingreso;
	}
	public void setFechaingreso(LocalDate fechaingreso) {
		this.fechaingreso = fechaingreso;
	}
	public LocalDate getFechasalida() {
		return fechasalida;
	}
	public void setFechasalida(LocalDate fechasalida) {
		this.fechasalida = fechasalida;
	}
	public List<Producto> getProducto() {
		return producto;
	}
	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}

	public Inventario(int id, String nombre, int cantidad, String categoria, LocalDate fechaingreso, LocalDate fechasalida, List<Producto> producto, Usuario usuario) {
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.categoria = categoria;
		this.fechaingreso = fechaingreso;
		this.fechasalida = fechasalida;
		this.producto = producto;
		this.usuario = usuario;
	}

	public Inventario() {
	}
}

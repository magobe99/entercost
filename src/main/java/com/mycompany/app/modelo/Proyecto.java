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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
@Table(name="proyecto")
public class Proyecto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idproyecto")
	private int id;
	@NotEmpty(message = "Nombre del proyecto es obligatorio")
	@Column(name="nombreproyecto")
	private String nombreproyecto;
	@NotNull
	@Min(value=10000)
	@Column(name="precioproyecto")
	private int precioproyecto;
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	@FutureOrPresent
	@Column(name="fechainicio")
	private LocalDate fechainicio;
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	@FutureOrPresent
	@Column(name="fechafinal")
	private LocalDate fechafinal;
	
		
	@OneToMany(mappedBy = "proyecto")
    private List<Producto> listProducto;
	
	@OneToMany(mappedBy = "proyecto")
    private List<Presupuesto> listPresupuesto;
	
	@ManyToOne
	@JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    private Usuario usuario;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreproyecto() {
		return nombreproyecto;
	}
	public void setNombreproyecto(String nombreproyecto) {
		this.nombreproyecto = nombreproyecto;
	}
	public int getPrecioproyecto() {
		return precioproyecto;
	}
	public void setPrecioproyecto(int precioproyecto) {
		this.precioproyecto = precioproyecto;
	}
	public LocalDate getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(LocalDate fechainicio) {
		this.fechainicio = fechainicio;
	}
	public LocalDate getFechafinal() {
		return fechafinal;
	}
	public void setFechafinal(LocalDate fechafinal) {
		this.fechafinal = fechafinal;
	}
	public List<Producto> getListProducto() {
		return listProducto;
	}
	public void setListProducto(List<Producto> listProducto) {
		this.listProducto = listProducto;
	}
	public List<Presupuesto> getListPresupuesto() {
		return listPresupuesto;
	}
	public void setListPresupuesto(List<Presupuesto> listPresupuesto) {
		this.listPresupuesto = listPresupuesto;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Proyecto(int id, String nombreproyecto, int precioproyecto, LocalDate fechainicio, LocalDate fechafinal, List<Producto> listProducto, List<Presupuesto> listPresupuesto, Usuario usuario) {
		this.id = id;
		this.nombreproyecto = nombreproyecto;
		this.precioproyecto = precioproyecto;
		this.fechainicio = fechainicio;
		this.fechafinal = fechafinal;
		this.listProducto = listProducto;
		this.listPresupuesto = listPresupuesto;
		this.usuario = usuario;
	}

	public Proyecto() {
	}
}

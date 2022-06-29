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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="producto")
public class Producto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idproducto")
	private int id;
	@NotEmpty(message="El nombre del producto es obligatorio")
	@Column(name="nombreproducto")
	private String nombreproducto;
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	@FutureOrPresent
	@Column(name="fechaproducto")
	private LocalDate fechaproducto;
	@NotNull
	@Min(value=5000)
	@Column(name="precioproducto")
	private int precioproducto;

	@NotNull
	@NotEmpty(message="La categoria del producto es obligatorio")
	@Column(name="categoriaproducto")
	private String categoriaproducto;
	
	@ManyToMany
    @JoinTable(name="producto_inventario",
            joinColumns = {@JoinColumn(name="idproducto",referencedColumnName="idproducto")},
            inverseJoinColumns = {@JoinColumn(name="idiventario",referencedColumnName="idinventario") })
     private List<Inventario> inventarios;
	
	@ManyToOne
	@JoinColumn(name = "idproyecto", referencedColumnName = "idproyecto")
    private Proyecto proyecto;
	
	@OneToMany(mappedBy = "producto")
    private List<Pedido> listPedido;

	public Producto() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	public LocalDate getFechaproducto() {
		return fechaproducto;
	}

	public void setFechaproducto(LocalDate fechaproducto) {
		this.fechaproducto = fechaproducto;
	}

	public int getPrecioproducto() {
		return precioproducto;
	}

	public void setPrecioproducto(int precioproducto) {
		this.precioproducto = precioproducto;
	}

	public String getCategoriaproducto() {
		return categoriaproducto;
	}

	public void setCategoriaproducto(String categoriaproducto) {
		this.categoriaproducto = categoriaproducto;
	}

	public List<Inventario> getInventarios() {
		return inventarios;
	}

	public void setInventarios(List<Inventario> inventarios) {
		this.inventarios = inventarios;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public List<Pedido> getListPedido() {
		return listPedido;
	}

	public void setListPedido(List<Pedido> listPedido) {
		this.listPedido = listPedido;
	}



	public Producto(int id, String nombreproducto, LocalDate fechaproducto, int precioproducto, String categoriaproducto, List<Inventario> inventarios, Proyecto proyecto, List<Pedido> listPedido) {
		this.id = id;
		this.nombreproducto = nombreproducto;
		this.fechaproducto = fechaproducto;
		this.precioproducto = precioproducto;
		this.categoriaproducto = categoriaproducto;
		this.inventarios = inventarios;
		this.proyecto = proyecto;
		this.listPedido = listPedido;
	}
}

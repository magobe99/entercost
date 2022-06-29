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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;


@Entity
@Table(name="compra")
public class Compra implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcompra")
	private int id;
	@NotEmpty(message = "El nombre de la compra es obligatorio")
	@Column (name="nombrecompra")
	private String nombrecompra;
	@NotNull
	@Min(value=5000)
	@Column(name="preciocompra")
	private int precio;
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	@FutureOrPresent
	@Column(name="fechacompra")
	private LocalDate fecha; 
	
	
	@ManyToMany(mappedBy = "compras")
   private List<Proveedor> proveedores;
			 
    @ManyToOne
    @JoinColumn(name = "idpresupuesto", referencedColumnName = "idpresupuesto")
    private Presupuesto presupuesto;
    
    @ManyToOne
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    private Usuario usuario;
    
    @OneToMany(mappedBy = "compra")
    private List<Balance> listBalance;
    
    @OneToMany(mappedBy = "compra")
    private List<Pedido> listPedido;
    
    @OneToMany(mappedBy = "compra")
    private List<Pago> listPago;

	public Presupuesto getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Balance> getListBalance() {
		return listBalance;
	}

	public String getNombrecompra() {
		return nombrecompra;
	}

	public void setNombrecompra(String nombrecompra) {
		this.nombrecompra = nombrecompra;
	}

	public void setListBalance(List<Balance> listBalance) {
		this.listBalance = listBalance;
	}

	public List<Pedido> getListPedido() {
		return listPedido;
	}

	public void setListPedido(List<Pedido> listPedido) {
		this.listPedido = listPedido;
	}

	public List<Pago> getListPago() {
		return listPago;
	}

	public void setListPago(List<Pago> listPago) {
		this.listPago = listPago;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

}
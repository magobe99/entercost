package com.mycompany.app.modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.time.ZoneId;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;

import lombok.ToString;
import org.exolab.castor.types.DateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.exception.DataException;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@ToString
@Data
@Entity
@Table(name="pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpedido")
	private int id;
	@NotEmpty(message = "Nombre del pedido es obligatorio")
	@Column(name="nombrepedido")
	private String nombrepedido;
	
	@NotNull
	@FutureOrPresent
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name="fechapedido")
	private LocalDate fechapedido;
		
	@ManyToOne
	@JoinColumn(name = "idcompra", referencedColumnName = "idcompra")  
    private Compra compra;
	
	@ManyToOne
	@JoinColumn(name = "idproducto", referencedColumnName = "idproducto")  
    private Producto producto;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombrepedido() {
		return nombrepedido;
	}
	public void setNombrepedido(String nombrepedido) {
		this.nombrepedido = nombrepedido;
	}
	public LocalDate getFechapedido() {
		return fechapedido;
	}
	public void setFechapedido(LocalDate fechapedido) {
		this.fechapedido = fechapedido;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
}

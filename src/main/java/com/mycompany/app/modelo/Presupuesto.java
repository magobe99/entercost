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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;


@Entity
@Table(name = "presupuesto")
public class Presupuesto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpresupuesto")
	private int idpresupuesto;
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	@FutureOrPresent
	@Column(name="fechapresupuesto")
	private LocalDate fechapresupuesto;
	@NotNull
	@Min(value=25000)
	@Column(name="valorpresupuesto")
	private int valorpresupuesto;
	
	
	@OneToMany(mappedBy = "presupuesto")
    private List<Compra> listCompra;
	
	@ManyToOne
    @JoinColumn(name = "idproyecto", referencedColumnName = "idproyecto")   
    private Proyecto proyecto;
	
	
	public int getIdpresupuesto() {
		return idpresupuesto;
	}
	public void setIdpresupuesto(int idpresupuesto) {
		this.idpresupuesto = idpresupuesto;
	}
	public LocalDate getFechapresupuesto() {
		return fechapresupuesto;
	}
	public void setFechapresupuesto(LocalDate fechapresupuesto) {
		this.fechapresupuesto = fechapresupuesto;
	}
	public int getValorpresupuesto() {
		return valorpresupuesto;
	}
	public void setValorpresupuesto(int valorpresupuesto) {
		this.valorpresupuesto = valorpresupuesto;
	}
	public List<Compra> getListCompra() {
		return listCompra;
	}
	public void setListCompra(List<Compra> listCompra) {
		this.listCompra = listCompra;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Presupuesto(int idpresupuesto, LocalDate fechapresupuesto, int valorpresupuesto, List<Compra> listCompra, Proyecto proyecto) {
		this.idpresupuesto = idpresupuesto;
		this.fechapresupuesto = fechapresupuesto;
		this.valorpresupuesto = valorpresupuesto;
		this.listCompra = listCompra;
		this.proyecto = proyecto;
	}

	public Presupuesto() {
	}
}
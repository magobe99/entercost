package com.mycompany.app.modelo;

import java.io.Serializable;
import java.time.LocalDate;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
@Table(name="balance")
public class Balance implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idbalance")
	private int idbalance;
	
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	@FutureOrPresent
	@Column(name="fechabalance")
	private LocalDate fechabalance;
	
	@NotNull
	@Min(value=1000)
	@Column(name="calculobalance")
	private int calculobalance;
	
	@ManyToOne
	@JoinColumn(name = "idcompra", referencedColumnName = "idcompra")
    private Compra compra;
	
	@ManyToOne
	@JoinColumn(name = "idpago", referencedColumnName = "idpago")
    private Pago pago;
	
	
	public int getIdbalance() {
		return idbalance;
	}
	public void setIdbalance(int idbalance) {
		this.idbalance = idbalance;
	}
	public LocalDate getFechabalance() {
		return fechabalance;
	}
	public void setFechabalance(LocalDate fechabalance) {
		this.fechabalance = fechabalance;
	}
	public int getCalculobalance() {
		return calculobalance;
	}
	public void setCalculobalance(int calculobalance) {
		this.calculobalance = calculobalance;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public Pago getPago() {
		return pago;
	}
	public void setPago(Pago pago) {
		this.pago = pago;
	}
	
	

}
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

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "pago")
public class Pago implements Serializable  {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "idpago")
	private int idpago;
	
	@NotNull
	@Min(value=1000)
	@Column(name = "preciopago")
	private int preciopago;
	
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	@FutureOrPresent
	@Column(name = "fechapago")
	private LocalDate fechapago;
	
	@NotNull(message="La categoria del producto es obligatorio")
	@Column(name = "estadopago")
	private boolean estadopago;
		
	@OneToMany(mappedBy = "pago")
    private List<Balance> listBalance;
		
	@ManyToOne
	@JoinColumn(name = "idcompra", referencedColumnName = "idcompra")
    private Compra compra;
	
	 @ManyToOne
	 @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
	 private Usuario usuario;
	
	
	public int getIdpago() {
		return idpago;
	}
	public void setIdpago(int idpago) {
		this.idpago = idpago;
	}
	public int getPreciopago() {
		return preciopago;
	}
	public void setPreciopago(int preciopago) {
		this.preciopago = preciopago;
	}
	public LocalDate getFechapago() {
		return fechapago;
	}
	public void setFechapago(LocalDate fechapago) {
		this.fechapago = fechapago;
	}
	public List<Balance> getListBalance() {
		return listBalance;
	}
	public void setListBalance(List<Balance> listBalance) {
		this.listBalance = listBalance;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public boolean isEstadopago() {
		return estadopago;
	}
	public void setEstadopago(boolean estadopago) {
		this.estadopago = estadopago;
	}
	
		
}
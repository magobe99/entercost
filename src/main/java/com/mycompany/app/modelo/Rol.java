package com.mycompany.app.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="rol")
public class Rol implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idrol")
	private int id;
	@Column(name="nombrerol")
	private String nombrerol;
	
	@ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombrerol() {
		return nombrerol;
	}

	public void setNombrerol(String nombrerol) {
		this.nombrerol = nombrerol;
	}

	

	public Rol(int id, String nombrerol, List<Usuario> usuarios) {
		super();
		this.id = id;
		this.nombrerol = nombrerol;
		
	}

	public Rol() {
		super();
	}

	public Rol(String nombrerol) {
		super();
		this.nombrerol = nombrerol;
	}
	
	

	
	
	

}

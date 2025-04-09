package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class coche {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCoche;
	private String marca;
	private String anio;
	private String cuentakm;
	
	
	public coche(long idCoche, String marca, String anio, String cuentakm) {
		super();
		this.idCoche = idCoche;
		this.marca = marca;
		this.anio = anio;
		this.cuentakm = cuentakm;
	}
	
	
	public coche() {
		super();
	}


	public long getIdCoche() {
		return idCoche;
	}
	public void setIdCoche(long idCoche) {
		this.idCoche = idCoche;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getCuentakm() {
		return cuentakm;
	}
	public void setCuentakm(String cuentakm) {
		this.cuentakm = cuentakm;
	}	
	
	
	
	
}

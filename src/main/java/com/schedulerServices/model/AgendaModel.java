package com.schedulerServices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agenda")
public class AgendaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_agenda")
	int cod_agenda;
	@Column(name = "titulo")
	String titulo;
	@Column(name = "descripcion")
	String descripcion;
	@Column(name = "fecha")
	String fecha;
	@Column(name = "cod_turista")
	int cod_turista;

	public AgendaModel(int cod_agenda, String titulo, String fecha, String descripcion, int cod_turista) {
		super();
		this.cod_agenda = cod_agenda;
		this.titulo = titulo;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.cod_turista = cod_turista;
	}

	public AgendaModel() {
		super();
	}

	public int getCod_agenda() {
		return cod_agenda;
	}

	public void setCod_agenda(int cod_agenda) {
		this.cod_agenda = cod_agenda;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCod_turista() {
		return cod_turista;
	}

	public void setCod_turista(int cod_turista) {
		this.cod_turista = cod_turista;
	}

	@Override
	public String toString() {
		return "AgendaModel [cod_agenda=" + cod_agenda + ", titulo=" + titulo + ", fecha=" + fecha + ", descripcion="
				+ descripcion + ", cod_turista=" + cod_turista + "]";
	}

}

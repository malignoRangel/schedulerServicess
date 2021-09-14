package com.schedulerServices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tarea")
public class TareaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_tarea")
	int cod_tarea;
	@Column(name = "titulo")
	String titulo;
	@Column(name = "descripcion")
	String descripcion;
	@Column(name = "fecha")
	String fecha;
	@Column(name = "status_tarea")
	boolean status_tarea;
	@Column(name = "cod_agenda")
	int cod_agenda;

	public TareaModel(int cod_tarea, String titulo, String descripcion, String fecha, boolean status_tarea,
			int cod_agenda) {
		super();
		this.cod_tarea = cod_tarea;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.status_tarea = status_tarea;
		this.cod_agenda = cod_agenda;
	}

	public TareaModel() {
		super();
	}

	public int getCod_tarea() {
		return cod_tarea;
	}

	public void setCod_tarea(int cod_tarea) {
		this.cod_tarea = cod_tarea;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public boolean isStatus_tarea() {
		return status_tarea;
	}

	public void setStatus_tarea(boolean status_tarea) {
		this.status_tarea = status_tarea;
	}
	

	public int getCod_agenda() {
		return cod_agenda;
	}

	public void setCod_agenda(int cod_agenda) {
		this.cod_agenda = cod_agenda;
	}

	@Override
	public String toString() {
		return "->" + "titulo de la tarea: " + titulo + ",\n descripcion: " + descripcion + ",\n fecha: "
				+ fecha + "\n\n";
	}


}

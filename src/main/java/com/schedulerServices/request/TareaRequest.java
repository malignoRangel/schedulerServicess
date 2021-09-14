package com.schedulerServices.request;

public class TareaRequest {

	int cod_tarea;
	String titulo;
	String descripcion;
	String fecha;
	boolean status_tarea;
	int cod_agenda;

	public TareaRequest(int cod_tarea, String titulo, String descripcion, String fecha, boolean status_tarea,
			int cod_agenda) {
		super();
		this.cod_tarea = cod_tarea;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.status_tarea = status_tarea;
		this.cod_agenda = cod_agenda;
	}

	public TareaRequest() {
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

	public boolean getStatus_tarea() {
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

}

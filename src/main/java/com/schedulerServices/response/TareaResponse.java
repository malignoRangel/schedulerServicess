package com.schedulerServices.response;

public class TareaResponse {

	int cod_tarea;
	String titulo;
	String descripcion;
	String fecha;
	boolean status_tarea;
	int cod_agenda;
	String mensaje;
	boolean satusValidate;

	public TareaResponse(int cod_tarea, String titulo, String descripcion, String fecha, boolean status_tarea,
			int cod_agenda, String mensaje, boolean satusValidate) {
		super();
		this.cod_tarea = cod_tarea;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.status_tarea = status_tarea;
		this.cod_agenda = cod_agenda;
		this.mensaje = mensaje;
		this.satusValidate = satusValidate;
	}

	public TareaResponse() {
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

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isSatusValidate() {
		return satusValidate;
	}

	public void setSatusValidate(boolean satusValidate) {
		this.satusValidate = satusValidate;
	}

}

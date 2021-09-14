package com.schedulerServices.response;

public class AgendaResponse {

	int cod_agenda;
	String titulo;
	String fecha;
	String descripcion;
	int cod_turista;
	String mensaje;
	boolean statusValidate;

	public AgendaResponse(int cod_agenda, String titulo, String fecha, String descripcion, int cod_turista,
			String mensaje, boolean statusValidate) {
		super();
		this.cod_agenda = cod_agenda;
		this.titulo = titulo;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.cod_turista = cod_turista;
		this.mensaje = mensaje;
		this.statusValidate = statusValidate;
	}

	public AgendaResponse() {
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

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isStatusValidate() {
		return statusValidate;
	}

	public void setStatusValidate(boolean statusValidate) {
		this.statusValidate = statusValidate;
	}

}

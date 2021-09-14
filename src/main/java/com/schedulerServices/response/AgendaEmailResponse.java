package com.schedulerServices.response;

public class AgendaEmailResponse {

	String mensaje;
	boolean statusValidate;

	public AgendaEmailResponse(String mensaje, boolean statusValidate) {
		super();
		this.mensaje = mensaje;
		this.statusValidate = statusValidate;
	}

	public AgendaEmailResponse() {
		super();
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

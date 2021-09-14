package com.schedulerServices.request;

public class AgendaEmailRequest {

	int cod_agenda;
	int cod_turista;
	String email;
	String nombreTurista;

	public AgendaEmailRequest(int cod_agenda, int cod_turista, String email, String nombreTurista) {
		super();
		this.cod_agenda = cod_agenda;
		this.cod_turista = cod_turista;
		this.email = email;
		this.nombreTurista = nombreTurista;
	}

	public AgendaEmailRequest() {
		super();
	}

	public int getCod_agenda() {
		return cod_agenda;
	}

	public void setCod_agenda(int cod_agenda) {
		this.cod_agenda = cod_agenda;
	}

	public int getCod_turista() {
		return cod_turista;
	}

	public void setCod_turista(int cod_turista) {
		this.cod_turista = cod_turista;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreTurista() {
		return nombreTurista;
	}

	public void setNombreTurista(String nombreTurista) {
		this.nombreTurista = nombreTurista;
	}

}

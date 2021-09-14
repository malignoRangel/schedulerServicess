package com.schedulerServices.controller;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.schedulerServices.model.AgendaModel;
import com.schedulerServices.model.TareaModel;
import com.schedulerServices.repository.AgendaRepository;
import com.schedulerServices.repository.TareaRepository;
import com.schedulerServices.request.AgendaEmailRequest;
import com.schedulerServices.request.AgendaRequest;
import com.schedulerServices.request.TareaRequest;
import com.schedulerServices.response.AgendaEmailResponse;
import com.schedulerServices.response.AgendaResponse;
import com.schedulerServices.response.TareaResponse;

@RestController
@RequestMapping(path = "/shcedulerServies")
public class SchedulerController {

	@Autowired
	private AgendaRepository agendaRepository;

	@Autowired
	private TareaRepository tareaRepository;

	@Autowired
	private JavaMailSender mailSender;

//	**********************************************
//	*SERVICIOS DEDICADOS A LA GESTION DE AGENDAS
//	**********************************************
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@RequestMapping(path = "/consultAgenda")
	public @ResponseBody List<AgendaModel> userResponse(@RequestBody AgendaRequest agenda) {

		List<AgendaModel> responseQuery = agendaRepository.findByCodTurista(agenda.getCod_turista());

		System.out.println("data que va a salir----->" + responseQuery);

		return responseQuery;
	}

	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@RequestMapping(path = "/consultByIdAgenda")
	public @ResponseBody AgendaResponse consultByIdAgenda(@RequestBody AgendaRequest agenda) {

		AgendaModel responseQuery = agendaRepository.findByCodAgenda(agenda.getCod_agenda());
		AgendaResponse response = new AgendaResponse();

		if (responseQuery != null) {
			response.setCod_agenda(responseQuery.getCod_agenda());
			response.setTitulo(responseQuery.getTitulo());
			response.setDescripcion(responseQuery.getDescripcion());
			response.setFecha(responseQuery.getFecha());
			response.setCod_turista(responseQuery.getCod_turista());
			response.setStatusValidate(true);
			response.setMensaje("Se encontro la agenda: " + responseQuery.getCod_agenda());
		} else {
			response.setStatusValidate(false);
			response.setMensaje("Error, no se encuentra la Agenda");
		}

		System.out.println("data que va a salir----->" + responseQuery);

		return response;
	}

	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@RequestMapping(path = "/crearAgenda")
	public @ResponseBody AgendaResponse crearAgenda(@RequestBody AgendaRequest agenda) {
		AgendaModel modelRq = new AgendaModel();
		AgendaResponse response = new AgendaResponse();

		try {
			modelRq.setTitulo(agenda.getTitulo());
			modelRq.setDescripcion(agenda.getDescripcion());
			modelRq.setFecha(agenda.getFecha());
			modelRq.setCod_turista(agenda.getCod_turista());
			agendaRepository.save(modelRq);
			response.setStatusValidate(true);
			response.setMensaje("se creo correctamente la Agenda.");
		} catch (Exception e) {
			response.setStatusValidate(false);
			response.setMensaje("Error en el servidor: " + e);
			System.out.println("Error en ---->" + e);
		}

		return response;
	}

	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@RequestMapping(path = "/deleteAgenda")
	public @ResponseBody AgendaResponse deleteAgenda(@RequestBody AgendaRequest agenda) {

		AgendaModel responseQuery = agendaRepository.findByCodAgendaAndCodTurista(agenda.getCod_agenda(),
				agenda.getCod_turista());
		AgendaResponse response = new AgendaResponse();

		try {
			if (responseQuery != null) {
				agendaRepository.delete(responseQuery);
				response.setMensaje("Se elimino la agenda");
				response.setStatusValidate(true);
			} else {
				response.setStatusValidate(false);
				response.setMensaje("Error, no se encuentra la Agenda");
			}
		} catch (Exception e) {
			response.setStatusValidate(false);
			response.setMensaje("Error en el servidor: " + e);
			System.out.println("Error en ---->" + e);
		}
		return response;
	}

	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@RequestMapping(path = "/updateAgenda")
	public @ResponseBody AgendaResponse updateAgenda(@RequestBody AgendaRequest agenda) {

		AgendaModel responseQuery = agendaRepository.findByCodAgendaAndCodTurista(agenda.getCod_agenda(),
				agenda.getCod_turista());
		AgendaResponse response = new AgendaResponse();

		try {
			if (responseQuery != null) {
				responseQuery.setTitulo(agenda.getTitulo());
				responseQuery.setDescripcion(agenda.getDescripcion());
				responseQuery.setFecha(agenda.getFecha());
				agendaRepository.save(responseQuery);
				response.setStatusValidate(true);
				response.setMensaje("Se actualizo la agenda correctamente.");
			} else {
				response.setStatusValidate(false);
				response.setMensaje("Error, no se encuentra la tarea");
			}
		} catch (Exception e) {
			response.setStatusValidate(false);
			response.setMensaje("Error en el servidor: " + e);
			System.out.println("Error en ---->" + e);
		}
		return response;
	}

//	**********************************************
//	*SERVICIOS DEDICADOS A LA GESTION DE TAREAS
//	**********************************************
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@RequestMapping(path = "/consultTareas")
	public @ResponseBody List<TareaModel> consultaTrea(@RequestBody TareaRequest tarea) {

		List<TareaModel> response = tareaRepository.findByCodAgenda(tarea.getCod_agenda());

		return response;
	}

	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@RequestMapping(path = "/consultaTreaById")
	public @ResponseBody TareaResponse consultaTreaById(@RequestBody TareaRequest tarea) {

		TareaResponse response = new TareaResponse();

		try {
			TareaModel responseQuery = tareaRepository.findByCodTareaById(tarea.getCod_tarea());
			if (responseQuery != null) {
				response.setTitulo(responseQuery.getTitulo());
				response.setCod_agenda(responseQuery.getCod_agenda());
				response.setCod_tarea(responseQuery.getCod_tarea());
				response.setDescripcion(responseQuery.getDescripcion());
				response.setFecha(responseQuery.getFecha());
				response.setStatus_tarea(responseQuery.isStatus_tarea());
				response.setSatusValidate(true);
				response.setMensaje("Se encontro correctamente la tarea");
			} else {
				response.setSatusValidate(false);
				response.setMensaje("Ne encontro correctamente la tarea");
			}

		} catch (Exception e) {
			response.setSatusValidate(false);
			response.setMensaje("Error en el servidor: " + e);
		}
		return response;
	}

	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@RequestMapping(path = "/crearTarea")
	public @ResponseBody TareaResponse crearTarea(@RequestBody TareaRequest tarea) {

		TareaResponse response = new TareaResponse();
		TareaModel modelRq = new TareaModel();
		try {
			modelRq.setTitulo(tarea.getTitulo());
			modelRq.setDescripcion(tarea.getDescripcion());
			modelRq.setFecha(tarea.getFecha());
			modelRq.setCod_agenda(tarea.getCod_agenda());
			modelRq.setStatus_tarea(tarea.isStatus_tarea());
			tareaRepository.save(modelRq);
			response.setSatusValidate(true);
			response.setMensaje("Se creo correctamente la tarea.");
		} catch (Exception e) {
			response.setSatusValidate(false);
			response.setMensaje("Error en el servidor: " + e);
		}
		return response;
	}

	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@RequestMapping(path = "/deleteTarea")
	public @ResponseBody TareaResponse deleteTarea(@RequestBody TareaRequest tarea) {

		TareaModel responseQuery = tareaRepository.findByCodTareaAndCodAgenda(tarea.getCod_tarea(),
				tarea.getCod_agenda());
		TareaResponse response = new TareaResponse();
		try {
			if (responseQuery != null) {
				tareaRepository.delete(responseQuery);
				response.setMensaje("Se elimino la tarea");
				response.setSatusValidate(true);
			} else {
				response.setSatusValidate(false);
				response.setMensaje("Error, no se encuentra la Agenda");
			}
		} catch (Exception e) {
			response.setSatusValidate(false);
			response.setMensaje("Error en el servidor: " + e);
			System.out.println("Error en ---->" + e);
		}
		return response;
	}

	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@RequestMapping(path = "/updateTarea")
	public @ResponseBody TareaResponse updateTarea(@RequestBody TareaRequest tarea) {

		TareaModel responseQuery = tareaRepository.findByCodTareaAndCodAgenda(tarea.getCod_tarea(),
				tarea.getCod_agenda());
		TareaResponse response = new TareaResponse();

		try {
			if (responseQuery != null) {
				responseQuery.setTitulo(tarea.getTitulo());
				responseQuery.setDescripcion(tarea.getDescripcion());
				responseQuery.setFecha(tarea.getFecha());
				responseQuery.setStatus_tarea(tarea.isStatus_tarea());
				tareaRepository.save(responseQuery);
				response.setSatusValidate(true);
				response.setMensaje("Se actualizo la tarea correctamente.");
			} else {
				response.setSatusValidate(false);
				response.setMensaje("Error, no se encuentra la tarea");
			}
		} catch (Exception e) {
			response.setSatusValidate(false);
			response.setMensaje("Error en el servidor: " + e);
			System.out.println("Error en ---->" + e);
		}
		return response;
	}

//	**********************************************
//	*SERVICIO DE ENVIO DE CORREO DE AGENDAS
//	**********************************************

	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@RequestMapping(path = "/enviarAgendaEmail")
	public @ResponseBody AgendaEmailResponse enviarAgendaEmail(@RequestBody AgendaEmailRequest agendaEmail) {
		System.out.println(
				"-----------------------------enviar agenda por email-----------------------------------------");

		AgendaModel responseQuery = agendaRepository.findByCodAgendaAndCodTurista(agendaEmail.getCod_agenda(),
				agendaEmail.getCod_turista());

		List<TareaModel> responseTarea = tareaRepository.findByCodAgenda(agendaEmail.getCod_agenda());

		AgendaEmailResponse response = new AgendaEmailResponse();

		System.out.println("......" + responseTarea);
		
		if (responseQuery != null) {
			try {
				MimeMessage mail = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(mail);
				helper.setTo(agendaEmail.getEmail());
				helper.setSubject(responseQuery.getTitulo());
				helper.setText("<p>Tu agenda:</p>" + "<p>" + responseQuery.getTitulo() + "</p>" + "<p>" + responseTarea + "\n</p>", true);
				System.out.println("-----pasa el texto");
				mailSender.send(mail);
				System.out.println("-------------------------->hace el send al mail");
				response.setStatusValidate(true);
				response.setMensaje("Se envio correctamente la agenda al correo");
			} catch (Exception e) {
				System.out.println("------------------catch-------------------");
				e.printStackTrace();
				response.setMensaje("Error con el servidor al enviar el correo");
			}
		} else {
			response.setMensaje("No se encuentra la agenda");
			response.setStatusValidate(false);
		}

		return response;

	}

}

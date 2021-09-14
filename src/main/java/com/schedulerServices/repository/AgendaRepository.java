package com.schedulerServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.schedulerServices.model.AgendaModel;

@RepositoryRestResource(exported = false)
public interface AgendaRepository extends CrudRepository<AgendaModel ,Long>{
	
	@Query("SELECT a FROM AgendaModel a where a.cod_turista=:cod_turista")
	List<AgendaModel> findByCodTurista(@Param("cod_turista") int cod_turista);
	
	@Query("SELECT a FROM AgendaModel a where a.cod_agenda=:cod_agenda")
	AgendaModel findByCodAgenda(@Param("cod_agenda") int cod_agenda);
	
	@Query("SELECT a FROM AgendaModel a where a.cod_agenda=:cod_agenda and a.cod_turista=:cod_turista")
	AgendaModel findByCodAgendaAndCodTurista(@Param("cod_agenda") int cod_agenda, @Param("cod_turista") int cod_turista);
	
	

}

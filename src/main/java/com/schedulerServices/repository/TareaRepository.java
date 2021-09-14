package com.schedulerServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.schedulerServices.model.TareaModel;

@RepositoryRestResource(exported = false)
public interface TareaRepository extends CrudRepository<TareaModel, Long>{

	@Query("SELECT t FROM TareaModel t where t.cod_agenda=:cod_agenda")
	List<TareaModel> findByCodAgenda(@Param("cod_agenda") int cod_agenda);
	
	@Query("SELECT t FROM TareaModel t where t.cod_tarea=:cod_tarea")
	TareaModel findByCodTareaById(@Param("cod_tarea") int cod_tarea);
	
	@Query("SELECT t FROM TareaModel t where t.cod_tarea=:cod_tarea and t.cod_agenda=:cod_agenda")
	TareaModel findByCodTareaAndCodAgenda(@Param("cod_tarea") int cod_tarea, @Param("cod_agenda") int cod_agenda);
	
}

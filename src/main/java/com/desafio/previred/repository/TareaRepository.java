package com.desafio.previred.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafio.previred.entity.Tarea;

@Repository
public interface TareaRepository extends CrudRepository<Tarea, Long> {

}

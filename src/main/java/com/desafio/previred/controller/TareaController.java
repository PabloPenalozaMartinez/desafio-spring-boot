package com.desafio.previred.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.previred.dto.ErrorResponse;
import com.desafio.previred.entity.Tarea;
import com.desafio.previred.service.TareaService;

@RestController
public class TareaController {

	@Autowired 
	private TareaService tareaService;
	
	@GetMapping("/tareas")
    public ResponseEntity<List<Tarea>> obtenerTareas(){
        return new ResponseEntity(tareaService.obtenerListaTareas(), HttpStatus.OK); 
    }
	
	@PostMapping("/tareas")
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea tarea){
		return new ResponseEntity(tareaService.crearTarea(tarea), HttpStatus.CREATED);
    }
	
	@PutMapping("/tareas")
    public ResponseEntity<Tarea> actualizarTarea(@RequestBody Tarea tarea){
		return new ResponseEntity(tareaService.actualizarTarea(tarea), HttpStatus.OK);
    }
	
	@DeleteMapping("/tareas/{tareaId}")
    public ResponseEntity<Tarea> eliminarTarea(@PathVariable("tareaId") Long tareaId){
		tareaService.eliminarTarea(tareaId);
        return new ResponseEntity(HttpStatus.OK); 
    }
	
	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleCustomerAlreadyExistsException(SQLException ex) {
	    return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}
}

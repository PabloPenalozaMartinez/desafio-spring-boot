package com.desafio.previred.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.previred.entity.Tarea;
import com.desafio.previred.repository.TareaRepository;

@Service
public class TareaServiceImpl implements TareaService{

	@Autowired
    private TareaRepository tareaRepository;
	
	@Override
	public Tarea crearTarea(Tarea tarea) {
		return tareaRepository.save(tarea);
	}

	@Override
	public List<Tarea> obtenerListaTareas() {
		return (List<Tarea>) tareaRepository.findAll();
	}

	@Override
	public Tarea actualizarTarea(Tarea tarea) {
		Tarea tareaBase = tareaRepository.findById(tarea.getId()).get();

	    if (Objects.nonNull(tarea.getDescripcion()) && !"".equalsIgnoreCase(tarea.getDescripcion())) {
	        tareaBase.setDescripcion(tarea.getDescripcion());
	    }
	
	    if (Objects.nonNull(tarea.getIdEstado()) && (tarea.getIdEstado().compareTo(Long.valueOf(0)) != 0)) {
	        tareaBase.setIdEstado(tarea.getIdEstado());
	    }
	
	    return tareaRepository.save(tareaBase);
	}

	@Override
	public void eliminarTarea(Long tareaId) {
		tareaRepository.deleteById(tareaId);		
	}

}

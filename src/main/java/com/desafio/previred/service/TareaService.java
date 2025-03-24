package com.desafio.previred.service;

import java.util.List;

import com.desafio.previred.entity.Tarea;

public interface TareaService {
	Tarea crearTarea(Tarea tarea);
    List<Tarea> obtenerListaTareas();
    Tarea actualizarTarea(Tarea tarea);
    void eliminarTarea(Long tareaId);
}

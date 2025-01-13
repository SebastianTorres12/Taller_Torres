package com.espe.micro_cursos_uwu.Service;

import com.espe.micro_cursos_uwu.Entity.Actividad;

import java.util.List;
import java.util.Optional;

public interface IActividadService {

    // Obtener todas las actividades
    List<Actividad> getAllActividades();

    // Obtener actividad por id
    Optional<Actividad> getActividadById(Integer id);

    // Guardar una nueva actividad
    Actividad saveActividad(Actividad actividad);

    // Eliminar una actividad
    void deleteActividadById(Integer id);

    // Actualizar una actividad
    Actividad updateActividad(Actividad actividad, Integer id);
}

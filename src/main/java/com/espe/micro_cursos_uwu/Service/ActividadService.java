package com.espe.micro_cursos_uwu.Service;

import com.espe.micro_cursos_uwu.Entity.Actividad;
import com.espe.micro_cursos_uwu.Repository.IActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActividadService implements IActividadService {

    @Autowired
    private IActividadRepository actividadRepository;

    @Override
    public List<Actividad> getAllActividades() {
        try {
            List<Actividad> actividades = actividadRepository.findAll();
            if (actividades.isEmpty()) {
                return new ArrayList<>();
            }
            return actividades;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Actividad> getActividadById(Integer id) {
        try {
            Optional<Actividad> actividad = actividadRepository.findById(Long.valueOf(id));
            if (actividad.isPresent()) {
                return actividad;
            } else {
                throw new RuntimeException("Actividad con id " + id + " no encontrada");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al buscar actividad con id " + id, e);
        }
    }

    @Override
    public Actividad saveActividad(Actividad actividad) {
        try {
            actividad.setFechaInicio(LocalDate.now());
            return actividadRepository.save(actividad);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al guardar la actividad", e);
        }
    }

    @Override
    public void deleteActividadById(Integer id) {
        try {
            Optional<Actividad> actividad = actividadRepository.findById(Long.valueOf(id));
            if (actividad.isPresent()) {
                actividadRepository.deleteById(Long.valueOf(id));
            } else {
                throw new RuntimeException("La actividad con id " + id + " ya fue eliminada o no existe");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Actividad updateActividad(Actividad actividad, Integer id) {
        try {
            Optional<Actividad> existingActividad = actividadRepository.findById(Long.valueOf(id));
            if (existingActividad.isPresent()) {
                Actividad updateActividad = existingActividad.get();
                updateActividad.setNombre(actividad.getNombre());
                updateActividad.setDescripcion(actividad.getDescripcion());
                updateActividad.setDuracionHoras(actividad.getDuracionHoras());
                updateActividad.setFechaInicio(actividad.getFechaInicio());
                return actividadRepository.save(updateActividad);
            } else {
                throw new RuntimeException("Actividad con id " + id + " no encontrada");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al actualizar la actividad con id " + id, e);
        }
    }
}

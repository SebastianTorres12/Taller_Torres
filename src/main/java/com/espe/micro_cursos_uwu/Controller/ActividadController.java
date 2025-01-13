package com.espe.micro_cursos_uwu.Controller;

import com.espe.micro_cursos_uwu.Entity.Actividad;
import com.espe.micro_cursos_uwu.Service.ActividadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/actividades")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    // Obtener todas las actividades
    @GetMapping
    public List<Actividad> getAllActividades() {
        return actividadService.getAllActividades();
    }

    // Obtener actividad por id
    @GetMapping("/{id}")
    public Optional<Actividad> getActividadById(@PathVariable("id") Integer id) {
        return actividadService.getActividadById(id);
    }

    // Crear una nueva actividad
    @PostMapping
    public Actividad createActividad(@Valid @RequestBody Actividad actividad) {
        return actividadService.saveActividad(actividad);
    }

    // Eliminar actividad por id
    @DeleteMapping("/{id}")
    public void deleteActividad(@PathVariable Integer id) {
        actividadService.deleteActividadById(id);
    }

    // Actualizar actividad
    @PutMapping("/{id}")
    public Actividad updateActividad(@Valid  @RequestBody Actividad actividad, @PathVariable("id") Integer id) {
        return actividadService.updateActividad(actividad, id);
    }
}

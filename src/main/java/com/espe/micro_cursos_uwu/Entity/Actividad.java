package com.espe.micro_cursos_uwu.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Table(name = "actividad")
@Entity
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres.")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotBlank(message = "La descripción no puede estar vacía.")
    @Size(max = 255, message = "La descripción no puede tener más de 255 caracteres.")
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Positive(message = "La duración debe ser un número positivo.")
    @Column(name = "duracion_horas", nullable = false)
    private int duracionHoras;

    @NotNull(message = "La fecha de inicio no puede ser nula.")
    @FutureOrPresent(message = "La fecha de inicio no puede ser en el pasado.")
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}

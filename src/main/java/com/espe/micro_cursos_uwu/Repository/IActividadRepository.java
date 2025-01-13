package com.espe.micro_cursos_uwu.Repository;

import com.espe.micro_cursos_uwu.Entity.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActividadRepository extends JpaRepository<Actividad, Long> {
}

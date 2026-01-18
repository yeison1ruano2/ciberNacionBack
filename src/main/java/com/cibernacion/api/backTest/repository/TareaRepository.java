package com.cibernacion.api.backTest.repository;

import com.cibernacion.api.backTest.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TareaRepository extends JpaRepository<Tarea,Long>, JpaSpecificationExecutor<Tarea> {

  long countByProyecto_IdAndActivoTrue(Long proyectoId);
}

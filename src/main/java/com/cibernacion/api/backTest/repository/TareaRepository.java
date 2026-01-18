package com.cibernacion.api.backTest.repository;

import com.cibernacion.api.backTest.model.Tarea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TareaRepository extends JpaRepository<Tarea,Long>, JpaSpecificationExecutor<Tarea> {
  //Page<Tarea> findByUsuarioId(Pageable pageable);

  /*Page<Tarea> findByUsuarioIdAndEstado(
          EstadoTarea estado,
          Pageable pageable
  );*/

  Page<Tarea> findAll(Pageable pageable);
}

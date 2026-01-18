package com.cibernacion.api.backTest.repository;

import com.cibernacion.api.backTest.model.Proyecto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProyectoRepository extends JpaRepository<Proyecto,Long>, JpaSpecificationExecutor<Proyecto> {

  Page<Proyecto> findByActivoTrue(Pageable pageable);
}

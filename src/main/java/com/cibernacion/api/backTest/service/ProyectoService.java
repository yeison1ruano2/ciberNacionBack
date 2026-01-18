package com.cibernacion.api.backTest.service;

import com.cibernacion.api.backTest.dto.ProyectoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProyectoService {
  ProyectoDto.Response crearProyecto(ProyectoDto.Request dto);

  ProyectoDto.Response eliminarProyecto(Long id);

  Page<ProyectoDto.Response> obtenerProyectos(Pageable pageable);
}

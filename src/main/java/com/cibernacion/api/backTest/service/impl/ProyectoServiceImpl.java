package com.cibernacion.api.backTest.service.impl;

import com.cibernacion.api.backTest.dto.ProyectoDto;
import com.cibernacion.api.backTest.exception.ResourceNotFoundException;
import com.cibernacion.api.backTest.mapper.ProyectoMapper;
import com.cibernacion.api.backTest.model.Proyecto;
import com.cibernacion.api.backTest.repository.ProyectoRepository;
import com.cibernacion.api.backTest.repository.TareaRepository;
import com.cibernacion.api.backTest.service.ProyectoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProyectoServiceImpl implements ProyectoService {

  private final ProyectoRepository proyectoRepository;
  private final TareaRepository tareaRepository;
  private final ProyectoMapper proyectoMapper;

  @Override
  public ProyectoDto.Response crearProyecto(ProyectoDto.Request dto) {
    Proyecto proyecto = new Proyecto();
    proyecto.setDescripcion(dto.getDescripcion());
    proyecto.setNombre(dto.getNombre());
    return proyectoMapper.toResponseDto(proyectoRepository.save(proyecto));
  }
  @Override
  public Page<ProyectoDto.Response> obtenerProyectos(Pageable pageable) {
    Page<Proyecto> responsePage = proyectoRepository.findByActivoTrue(pageable);
    return responsePage.map(proyecto -> {
      long totalTareasActivas = tareaRepository.countByProyecto_IdAndActivoTrue(proyecto.getId());
      ProyectoDto.Response dto = proyectoMapper.toResponseDto(proyecto);
      if(totalTareasActivas>0){
        dto.setTotalTareas(totalTareasActivas);
      }
      return dto;
    });
  }

  @Override
  public ProyectoDto.Response eliminarProyecto(Long id) {
    Proyecto proyecto = proyectoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Proyecto no encontrada"));
    proyecto.setActivo(false);
    return proyectoMapper.toResponseDto(proyectoRepository.save(proyecto));
  }
}

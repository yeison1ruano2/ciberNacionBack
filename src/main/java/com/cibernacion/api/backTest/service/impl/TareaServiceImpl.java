package com.cibernacion.api.backTest.service.impl;

import com.cibernacion.api.backTest.dto.TareaDto;
import com.cibernacion.api.backTest.enums.EstadoTarea;
import com.cibernacion.api.backTest.enums.Prioridad;
import com.cibernacion.api.backTest.exception.ResourceNotFoundException;
import com.cibernacion.api.backTest.mapper.TareaMapper;
import com.cibernacion.api.backTest.model.Proyecto;
import com.cibernacion.api.backTest.model.Tarea;
import com.cibernacion.api.backTest.repository.ProyectoRepository;
import com.cibernacion.api.backTest.repository.TareaRepository;
import com.cibernacion.api.backTest.service.TareaService;
import com.cibernacion.api.backTest.specification.TareaSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TareaServiceImpl implements TareaService {

  private final TareaRepository tareaRepository;
  private final ProyectoRepository proyectoRepository;
  private final TareaMapper tareaMapper;


  @Override
  public TareaDto.Response crearTarea(TareaDto.Request dto,Long proyectoId) {
    Tarea tarea = new Tarea();
    tarea.setEstado(dto.getEstado());
    tarea.setDescripcion(dto.getDescripcion());
    tarea.setPrioridad(dto.getPrioridad());
    tarea.setTitulo(dto.getTitulo());
    tarea.setFechaLimite(dto.getFechaLimite());
    Proyecto proyecto = proyectoRepository.findById(proyectoId).orElseThrow(()-> new ResourceNotFoundException("Proyecto no encontrado"));
    tarea.setProyecto(proyecto);
    tarea.setActivo(true);
    return tareaMapper.toResponseDto(tareaRepository.save(tarea));
  }

  @Override
  public TareaDto.Response obtenerPorId(Long id) {
    return tareaRepository.findById(id).map(tareaMapper::toResponseDto).orElseThrow(()->new ResourceNotFoundException("Tarea no encontrada"));
  }

  @Override
  public Page<TareaDto.Response> obtenerTareas(Pageable pageable) {
     Page<Tarea> responsePage = tareaRepository.findAll(pageable);
     return responsePage.map(tareaMapper::toResponseDto);
  }

  @Override
  public TareaDto.Response eliminarTarea(Long id) {
    Tarea tarea = tareaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Tarea no encontrada"));
    tarea.setActivo(false);
    return tareaMapper.toResponseDto(tareaRepository.save(tarea));
  }

  @Override
  public Page<TareaDto.Response> filtrarTareas(Long proyectoId,Prioridad prioridad, EstadoTarea estado, LocalDate fechaLimite, Boolean activo, Pageable pageable) {
    Specification<Tarea> spec = Specification.where(TareaSpecification.isActivo(activo))
            .and(TareaSpecification.hasProyectoId(proyectoId))
            .and(TareaSpecification.hasPrioridad(prioridad))
            .and(TareaSpecification.hasEstado(estado))
            .and(TareaSpecification.hasFechaLimite(fechaLimite));
    return tareaRepository.findAll(spec,pageable).map(tareaMapper::toResponseDto);
  }

  @Override
  public Page<TareaDto.Response> obtenerTareasDelMes(int anio, int mes, Pageable pageable) {
    LocalDate inicio = LocalDate.of(anio,mes,1);
    LocalDate fin = inicio.withDayOfMonth(inicio.lengthOfMonth());
    Specification<Tarea> spec = Specification.where(TareaSpecification.hasFechaEntre(inicio,fin));
    return tareaRepository.findAll(spec,pageable).map(tareaMapper::toResponseDto);
  }

  @Override
  public TareaDto.Response actualizarEstado(Long id, EstadoTarea estado) {
    Tarea tarea = tareaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Tarea no encontrada"));
    tarea.setEstado(estado);
    return tareaMapper.toResponseDto(tareaRepository.save(tarea));
  }

  @Override
  public TareaDto.Response actualizarTarea(Long id, TareaDto.Request dto) {
    Tarea tarea = tareaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Tarea no encontrada"));
    tarea.setTitulo(dto.getTitulo());
    tarea.setDescripcion(dto.getDescripcion());
    tarea.setPrioridad(dto.getPrioridad());
    tarea.setEstado(dto.getEstado());
    tarea.setFechaLimite(dto.getFechaLimite());
    return tareaMapper.toResponseDto(tareaRepository.save(tarea));
  }
}

package com.cibernacion.api.backTest.service;

import com.cibernacion.api.backTest.dto.TareaDto;
import com.cibernacion.api.backTest.enums.EstadoTarea;
import com.cibernacion.api.backTest.enums.Prioridad;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface TareaService {

  TareaDto.Response crearTarea(TareaDto.Request dto);

  TareaDto.Response obtenerPorId(Long id);

  //Page<TareaDto.Response> listarPorUsuario(EstadoTarea estado, Pageable pageable);

  Page<TareaDto.Response> obtenerTareas(Pageable pageable);

  TareaDto.Response eliminarTarea(Long id);

  Page<TareaDto.Response> filtrarTareas(Prioridad prioridad, EstadoTarea estado, LocalDate fechaLimite,Boolean activo,Pageable pageable);

  Page<TareaDto.Response> obtenerTareasDelMes(int anio, int mes, Pageable pageable);

  TareaDto.Response actualizarEstado(Long id, EstadoTarea estado);

  TareaDto.Response actualizarTarea(Long id, TareaDto.Request dto);
}

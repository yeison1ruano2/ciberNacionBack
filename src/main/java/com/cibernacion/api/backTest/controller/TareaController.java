package com.cibernacion.api.backTest.controller;

import com.cibernacion.api.backTest.dto.TareaDto;
import com.cibernacion.api.backTest.enums.EstadoTarea;
import com.cibernacion.api.backTest.enums.Prioridad;
import com.cibernacion.api.backTest.service.TareaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/tareas")
@RequiredArgsConstructor
@Slf4j
public class TareaController {

  private final TareaService tareaService;

  @PostMapping
  public ResponseEntity<TareaDto.Response> crear(@Valid @RequestBody TareaDto.Request dto){
    TareaDto.Response response = tareaService.crearTarea(dto);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TareaDto.Response> obtenerPorId(@PathVariable Long id){
    TareaDto.Response response = tareaService.obtenerPorId(id);
    return ResponseEntity.ok(response);
  }

  @PutMapping("/{id}/estado")
  public ResponseEntity<TareaDto.Response> actualizarEstado(@PathVariable Long id,@RequestParam("estado") EstadoTarea estado){
    TareaDto.Response response = tareaService.actualizarEstado(id,estado);
    return ResponseEntity.ok(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<TareaDto.Response>actualizarTarea(@PathVariable Long id,@Valid @RequestBody TareaDto.Request dto){
    TareaDto.Response response = tareaService.actualizarTarea(id,dto);
    return ResponseEntity.ok(response);
  }

  @GetMapping()
  public ResponseEntity<Page<TareaDto.Response>> obtenerTareas(Pageable pageable){
    Page<TareaDto.Response> response = tareaService.obtenerTareas(pageable);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/filtrar")
  public ResponseEntity<Page<TareaDto.Response>> filtrarTareas(@RequestParam(required = false) EstadoTarea estado,
                                                               @RequestParam(required = false) Prioridad prioridad,
                                                               @RequestParam(required = false) LocalDate fechaLimite,
                                                               @RequestParam(required = false) Boolean activo,
                                                               Pageable pageable){
    Page<TareaDto.Response> response = tareaService.filtrarTareas(prioridad,estado,fechaLimite,activo,pageable);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<TareaDto.Response> eliminarTarea(@PathVariable Long id){
    TareaDto.Response response = tareaService.eliminarTarea(id);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/mes")
  public ResponseEntity<Page<TareaDto.Response>> filtrarPorMes(@RequestParam int anio, @RequestParam int mes,Pageable pageable){
    Page<TareaDto.Response> response = tareaService.obtenerTareasDelMes(anio,mes,pageable);
    return ResponseEntity.ok(response);
  }
}

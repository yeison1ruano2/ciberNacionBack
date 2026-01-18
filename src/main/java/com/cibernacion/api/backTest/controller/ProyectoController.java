package com.cibernacion.api.backTest.controller;

import com.cibernacion.api.backTest.dto.ProyectoDto;
import com.cibernacion.api.backTest.service.ProyectoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proyectos")
@RequiredArgsConstructor
public class ProyectoController {

  private final ProyectoService proyectoService;

  @PostMapping
  public ResponseEntity<ProyectoDto.Response> crearProyecto(@Valid @RequestBody ProyectoDto.Request dto){
    ProyectoDto.Response response = proyectoService.crearProyecto(dto);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/filtrar")
  public ResponseEntity<Page<ProyectoDto.Response>> filtrarProyectos(Pageable pageable){
    Page<ProyectoDto.Response> response = proyectoService.obtenerProyectos(pageable);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ProyectoDto.Response> eliminarProyecto(@PathVariable Long id){
    ProyectoDto.Response response = proyectoService.eliminarProyecto(id);
    return ResponseEntity.ok(response);
  }
}

package com.cibernacion.api.backTest.controller;

import com.cibernacion.api.backTest.dto.UsuarioDto;
import com.cibernacion.api.backTest.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@Slf4j
public class UsuarioController {

  private final UsuarioService usuarioService;

  @PostMapping
  public ResponseEntity<UsuarioDto.Response> crear(@Valid @RequestBody UsuarioDto.Request dto){
    UsuarioDto.Response response =  usuarioService.crearUsuario(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UsuarioDto.Response> obtenerPorId(@PathVariable Long id){
    UsuarioDto.Response response = usuarioService.obtenerPorId(id);
    return ResponseEntity.ok(response);
  }

  @GetMapping
  public ResponseEntity<List<UsuarioDto.Response>> listar(){
    List<UsuarioDto.Response> response =  usuarioService.listarUsuarios();
    return ResponseEntity.ok(response);
  }

}

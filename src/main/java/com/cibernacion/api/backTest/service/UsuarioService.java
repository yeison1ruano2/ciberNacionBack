package com.cibernacion.api.backTest.service;

import com.cibernacion.api.backTest.dto.UsuarioDto;

import java.util.List;

public interface UsuarioService {

  UsuarioDto.Response crearUsuario(UsuarioDto.Request dto);

  UsuarioDto.Response obtenerPorId(Long id);

  List<UsuarioDto.Response> listarUsuarios();

}

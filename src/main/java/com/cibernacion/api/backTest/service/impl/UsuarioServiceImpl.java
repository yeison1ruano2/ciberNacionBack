package com.cibernacion.api.backTest.service.impl;

import com.cibernacion.api.backTest.dto.UsuarioDto;
import com.cibernacion.api.backTest.exception.BusinessException;
import com.cibernacion.api.backTest.exception.ResourceNotFoundException;
import com.cibernacion.api.backTest.mapper.UsuarioMapper;
import com.cibernacion.api.backTest.model.Usuario;
import com.cibernacion.api.backTest.repository.UsuarioRepository;
import com.cibernacion.api.backTest.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

  private final UsuarioRepository usuarioRepository;

  private final UsuarioMapper usuarioMapper;


  @Override
  public UsuarioDto.Response crearUsuario(UsuarioDto.Request dto) {
    if(usuarioRepository.existsByEmail(dto.getEmail())){
      throw new BusinessException("El email ya está registrado");
    }
    Usuario usuario = usuarioMapper.toEntity(dto);
    Usuario usuarioGuardado = usuarioRepository.save(usuario);
    return usuarioMapper.toResponseDto(usuarioGuardado);
  }

  @Override
  public UsuarioDto.Response obtenerPorId(Long id) {
    Usuario usuario = usuarioRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Usuario no encontrado"));
    return usuarioMapper.toResponseDto(usuario);
  }

  @Override
  public List<UsuarioDto.Response> listarUsuarios() {
    return usuarioRepository.findAll().stream().map(usuarioMapper::toResponseDto).toList();
  }
}

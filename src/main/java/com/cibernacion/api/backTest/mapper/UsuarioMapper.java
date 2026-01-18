package com.cibernacion.api.backTest.mapper;

import com.cibernacion.api.backTest.dto.UsuarioDto;
import com.cibernacion.api.backTest.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = CentralMapperConfig.class)
public interface UsuarioMapper {

  Usuario toEntity(UsuarioDto.Request dto);

  UsuarioDto.Response toResponseDto(Usuario entity);
}

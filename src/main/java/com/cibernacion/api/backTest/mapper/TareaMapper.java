package com.cibernacion.api.backTest.mapper;

import com.cibernacion.api.backTest.dto.TareaDto;
import com.cibernacion.api.backTest.model.Tarea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        config = CentralMapperConfig.class,
        uses = { UsuarioMapper.class }
)
public interface TareaMapper {
  Tarea toEntity(TareaDto.Request dto);

  TareaDto.Response toResponseDto(Tarea entity);
}

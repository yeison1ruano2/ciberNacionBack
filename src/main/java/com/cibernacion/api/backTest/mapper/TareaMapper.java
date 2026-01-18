package com.cibernacion.api.backTest.mapper;

import com.cibernacion.api.backTest.dto.TareaDto;
import com.cibernacion.api.backTest.model.Tarea;
import org.mapstruct.Mapper;

@Mapper(
        config = CentralMapperConfig.class,
        uses = { UsuarioMapper.class }
)
public interface TareaMapper {

  TareaDto.Response toResponseDto(Tarea entity);
}

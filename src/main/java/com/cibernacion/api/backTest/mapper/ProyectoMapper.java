package com.cibernacion.api.backTest.mapper;

import com.cibernacion.api.backTest.dto.ProyectoDto;
import com.cibernacion.api.backTest.model.Proyecto;
import org.mapstruct.Mapper;

@Mapper(
        config = CentralMapperConfig.class,
        uses = { ProyectoMapper.class }
)
public interface ProyectoMapper {

  ProyectoDto.Response toResponseDto(Proyecto entity);
}

package com.cibernacion.api.backTest.dto;

import com.cibernacion.api.backTest.enums.EstadoTarea;
import jakarta.validation.constraints.NotNull;

public class TareaEstadoDto {
  @NotNull(message = "El estado es obligatorio")
   private EstadoTarea estado;
}

package com.cibernacion.api.backTest.dto;

import com.cibernacion.api.backTest.enums.EstadoTarea;
import com.cibernacion.api.backTest.enums.Prioridad;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class TareaDto {

  @Getter
  @Setter
  public static class Request {
    @NotBlank(message = "El título es obligatorio")
    @Size(max = 120, message = "El título no puede superar 120 caracteres")
    private String titulo;

    @Size(max = 500, message = "La descripción no puede superar 500 caracteres")
    private String descripcion;

    @NotNull(message = "La prioridad es obligatoria")
    private Prioridad prioridad;

    @NotNull(message = "La fecha límite es obligatoria")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaLimite;

    @NotNull(message = "El estado es obligatorio")
    private EstadoTarea estado;
  }

  @Getter
  @Setter
  public static class Response {
    private Long id;
    private String titulo;
    private String descripcion;
    private Prioridad prioridad;
    private EstadoTarea estado;
    private LocalDate fechaLimite;
  }
}

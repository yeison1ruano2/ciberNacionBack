package com.cibernacion.api.backTest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class ProyectoDto {

  @Getter
  @Setter
  public static class Request{
    @NotBlank(message = "El título es obligatorio")
    private String nombre;

    @Size(max = 500, message = "La descripción no puede superar 500 caracteres")
    private String descripcion;
  }

  @Getter
  @Setter
  public static class Response {
    private Long id;
    private String nombre;
    private String descripcion;
    private long totalTareas;
  }
}

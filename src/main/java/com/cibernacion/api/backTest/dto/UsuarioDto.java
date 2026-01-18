package com.cibernacion.api.backTest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class UsuarioDto {

  @Getter
  @Setter
  public static class Request {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no es válido")
    private String email;
  }

  @Getter
  @Setter
  public static class Response{
    private Long id;
    private String nombre;
    private String email;
  }
}

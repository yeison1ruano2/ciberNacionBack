package com.cibernacion.api.backTest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false,length = 100)
  private String nombre;

  @Column(nullable = false, unique = true, length = 150)
  private String email;

  @Column(nullable = false)
  private Boolean activo = true;

  @Column(nullable = false, updatable = false)
  private LocalDate fechaCreacion;

  @PrePersist
  public void prePresist(){
    this.fechaCreacion = LocalDate.now();
  }
}

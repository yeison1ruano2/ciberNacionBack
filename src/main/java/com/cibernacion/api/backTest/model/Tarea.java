package com.cibernacion.api.backTest.model;

import com.cibernacion.api.backTest.enums.EstadoTarea;
import com.cibernacion.api.backTest.enums.Prioridad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity @Table(name="tareas")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Tarea {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 120)
  private String titulo;

  @Column(length = 500)
  private String descripcion;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 20)
  private Prioridad prioridad;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 20)
  private EstadoTarea estado;

  @Column(nullable = false)
  private LocalDate fechaLimite;

  @Column(nullable = false)
  private Boolean activo = true;

  @Column(nullable = false, updatable = false)
  private LocalDate fechaCreacion;

  @Column(nullable = false)
  private LocalDate fechaActualizacion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "proyecto_id")
  private Proyecto proyecto;


  @PrePersist
  public void prePersist() {
    this.fechaCreacion = LocalDate.now();
    this.fechaActualizacion = LocalDate.now();
  }

  @PreUpdate
  public void preUpdate() {
    this.fechaActualizacion = LocalDate.now();
  }

}

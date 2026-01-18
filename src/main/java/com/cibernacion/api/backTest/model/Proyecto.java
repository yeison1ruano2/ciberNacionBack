package com.cibernacion.api.backTest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity @Table(name="proyectos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Proyecto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nombre;

  private String descripcion;

  private Boolean activo = true;

  @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Tarea> tareas = new ArrayList<>();

}

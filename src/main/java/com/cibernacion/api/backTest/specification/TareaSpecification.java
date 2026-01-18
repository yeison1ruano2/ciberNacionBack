package com.cibernacion.api.backTest.specification;

import com.cibernacion.api.backTest.enums.EstadoTarea;
import com.cibernacion.api.backTest.enums.Prioridad;
import com.cibernacion.api.backTest.model.Tarea;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class TareaSpecification {

  public static Specification<Tarea> hasEstado(EstadoTarea estado){
    return (root,query,cb)->estado!=null ? cb.equal(root.get("estado"),estado):cb.conjunction();
  }

  public static Specification<Tarea> hasPrioridad(Prioridad prioridad){
    return(root,query,cb)->prioridad!=null ? cb.equal(root.get("prioridad"),prioridad):cb.conjunction();
  }

  public static Specification<Tarea>isActivo(Boolean activo){
    return (root,query,cb)->{
      if(activo == null){
        return cb.conjunction();
      }
      return cb.equal(root.get("activo"),activo);
    };
  }

  public static Specification<Tarea> hasFechaLimite(LocalDate fechaLimite){
    return (root,query,cb)->{
      if(fechaLimite==null){
        return cb.conjunction();
      }
      return cb.equal(root.get("fechaLimite"),fechaLimite);
    };
  }

  public static Specification<Tarea> hasFechaEntre(LocalDate inicio, LocalDate fin) {
    return (root, query, cb) -> {
      if (inicio == null || fin == null) {
        return cb.conjunction();
      }
      return cb.between(root.get("fechaLimite"), inicio, fin);
    };
  }
}

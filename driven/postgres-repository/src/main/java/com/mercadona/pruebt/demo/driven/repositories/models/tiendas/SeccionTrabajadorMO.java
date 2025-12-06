package com.mercadona.pruebt.demo.driven.repositories.models.tiendas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seccion_trabajador")
public class SeccionTrabajadorMO {

  @Id
  @Column(name = "seccion_trabajador_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "trabajador_id")
  private Long trabajadorId;

  @Column(name = "seccion_id")
  private Long seccionId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "trabajador_id", referencedColumnName = "trabajador_id", insertable = false, updatable = false)
  private TrabajadorMO trabajador;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "seccion_id", referencedColumnName = "seccion_id", insertable = false, updatable = false)
  private SeccionMO seccion;
}

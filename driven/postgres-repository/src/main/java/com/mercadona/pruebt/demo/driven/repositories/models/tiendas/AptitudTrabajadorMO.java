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
@Table(name = "aptitud_trabajador")
public class AptitudTrabajadorMO {

  @Id
  @Column(name = "aptitud_trabajador_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "trabajador_id")
  private Long trabajadorId;

  @Column(name = "aptitud_id")
  private Long aptitud_id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "trabajador_id", referencedColumnName = "trabajador_id", insertable = false, updatable = false)
  private TrabajadorMO trabajador;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "aptitud_id", referencedColumnName = "aptitud_id", insertable = false, updatable = false)
  private AptitudMO aptitud;
}

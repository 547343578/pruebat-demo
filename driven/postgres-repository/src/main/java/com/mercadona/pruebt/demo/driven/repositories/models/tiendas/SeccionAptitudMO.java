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
@Table(name = "seccion_aptitud")
public class SeccionAptitudMO {
  @Id
  @Column(name = "seccion_aptitud_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "seccion_id")
  private Long seccionId;

  @Column(name = "aptitud_id")
  private Long aptitudId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "aptitud_id", referencedColumnName = "aptitud_id", insertable = false, updatable = false)
  private AptitudMO aptitud;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "seccion_id", referencedColumnName = "seccion_id", insertable = false, updatable = false)
  private SeccionMO seccion;
}

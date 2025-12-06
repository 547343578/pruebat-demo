package com.mercadona.pruebt.demo.driven.repositories.models.tiendas;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "secciones")
public class SeccionMO {

  @Id
  @Column(name = "seccion_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "horas_diarias")
  private Integer horasDiarias;

  @OneToMany(mappedBy = "seccion", fetch = FetchType.LAZY)
  private List<SeccionTrabajadorMO> seccionTrabajadores;
  @OneToMany(mappedBy = "seccion", fetch = FetchType.LAZY)
  private List<SeccionAptitudMO> seccionAptitudes;
}

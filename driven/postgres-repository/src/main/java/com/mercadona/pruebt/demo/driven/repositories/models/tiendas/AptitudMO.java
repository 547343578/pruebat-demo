package com.mercadona.pruebt.demo.driven.repositories.models.tiendas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aptitudes")
public class AptitudMO {


  @Id
  @Column(name = "aptitud_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "descripcion")
  private String descripcion;

  @OneToMany(mappedBy = "aptitud", fetch = FetchType.LAZY)
  private List<AptitudTrabajadorMO> aptitudTrabajadores;

  @OneToMany(mappedBy = "aptitud", fetch = FetchType.LAZY)
  private List<SeccionAptitudMO> seccionAptitudes;
}

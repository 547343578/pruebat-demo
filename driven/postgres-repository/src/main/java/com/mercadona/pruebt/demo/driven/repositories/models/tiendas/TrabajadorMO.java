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
@Table(name = "trabajadores")
public class TrabajadorMO {

  @Id
  @Column(name = "trabajador_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "dni")
  private String dni;

  @Column(name = "tienda_id")
  private Long tiendaId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tienda_id", referencedColumnName = "tienda_id", insertable = false, updatable = false)
  private TiendaMO tienda;

  @OneToMany(mappedBy = "trabajador", fetch = FetchType.LAZY)
  private List<AptitudTrabajadorMO> aptitudTrabajadores;

  @OneToMany(mappedBy = "trabajador", fetch = FetchType.LAZY)
  private List<SeccionTrabajadorMO> seccionTrabajadores;
}

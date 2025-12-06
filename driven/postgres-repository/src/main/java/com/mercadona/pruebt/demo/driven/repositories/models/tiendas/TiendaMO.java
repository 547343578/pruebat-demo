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
@Table(name = "tiendas")
public class TiendaMO {

  @Id
  @Column(name = "tienda_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "direccion")
  private String direccion;

  @OneToMany(mappedBy = "tienda", fetch = FetchType.LAZY)
  private List<TrabajadorMO> trabajadores;
}

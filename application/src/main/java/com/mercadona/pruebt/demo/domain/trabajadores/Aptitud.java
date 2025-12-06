package com.mercadona.pruebt.demo.domain.trabajadores;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Aptitud {
  private Long id;
  private String descripcion;
}

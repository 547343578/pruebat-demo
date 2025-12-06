package com.mercadona.pruebt.demo.driving.controllers.models.trabajadores;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AptitudDto {
  private Long id;
  private String descripcion;
}

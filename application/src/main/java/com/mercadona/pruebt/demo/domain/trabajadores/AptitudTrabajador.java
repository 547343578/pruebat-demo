package com.mercadona.pruebt.demo.domain.trabajadores;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AptitudTrabajador {
  private Long id;
  private Long trabajadorId;
  private Long aptitudId;
}

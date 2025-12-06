package com.mercadona.pruebt.demo.driving.controllers.models.trabajadores;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrabajadorDto {

  private Long id;
  @NotNull
  private String nombre;
  @NotNull
  private String dni;
  @NotNull
  private Long tiendaId;
  private List<AptitudDto> aptitudes;
}

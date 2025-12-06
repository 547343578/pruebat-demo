package com.mercadona.pruebt.demo.driving.controllers.apis;

import com.mercadona.pruebt.demo.driving.controllers.models.pagination.PageRequestDto;
import com.mercadona.pruebt.demo.driving.controllers.models.pagination.PageResponseDto;
import com.mercadona.pruebt.demo.driving.controllers.models.trabajadores.TrabajadorDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Trabajador api", description = "Trabajador API")
@RequestMapping("/api/v1/trabajadores")
public interface TrabajadorApi {

  @Operation(summary = "Consulta todos los trabajadores")
  @GetMapping
  ResponseEntity<PageResponseDto<TrabajadorDto>> getAll(PageRequestDto pageRequestDto);

  @Operation(summary = "Consulta todos los trabajadores")
  @GetMapping("/{id}")
  ResponseEntity<TrabajadorDto> getById(@PathVariable Long id);

  @Operation(summary = "Consulta todos los trabajadores")
  @PostMapping
  ResponseEntity<Void> create(@RequestBody @Validated TrabajadorDto trabajadorDto);

  @Operation(summary = "Consulta todos los trabajadores")
  @PutMapping("/{id}")
  ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Validated TrabajadorDto trabajadorDto);

  @Operation(summary = "Consulta todos los trabajadores")
  @DeleteMapping("/{id}")
  ResponseEntity<Void> delete(@PathVariable Long id);

}

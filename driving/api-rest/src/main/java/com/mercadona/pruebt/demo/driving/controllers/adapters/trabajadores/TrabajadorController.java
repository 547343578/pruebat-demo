package com.mercadona.pruebt.demo.driving.controllers.adapters.trabajadores;

import com.mercadona.pruebt.demo.application.ports.driving.TrabajadorPort;
import com.mercadona.pruebt.demo.domain.pagination.PageRequest;
import com.mercadona.pruebt.demo.domain.trabajadores.Trabajador;
import com.mercadona.pruebt.demo.driving.controllers.apis.TrabajadorApi;
import com.mercadona.pruebt.demo.driving.controllers.mappers.trabajadores.TrabajadorDtoMapper;
import com.mercadona.pruebt.demo.driving.controllers.models.pagination.PageRequestDto;
import com.mercadona.pruebt.demo.driving.controllers.models.pagination.PageResponseDto;
import com.mercadona.pruebt.demo.driving.controllers.models.trabajadores.TrabajadorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TrabajadorController implements TrabajadorApi {

  private final TrabajadorPort port;
  private final TrabajadorDtoMapper dtoMapper;

  @Override
  public ResponseEntity<PageResponseDto<TrabajadorDto>> getAll(PageRequestDto pageRequestDto) {
    var pageRequest = dtoMapper.toDomain(pageRequestDto);
    var page = port.getAll(pageRequest);
    return ResponseEntity.ok(dtoMapper.toDto(page));
  }

  @Override
  public ResponseEntity<TrabajadorDto> getById(Long id) {
    var trabajador = port.getById(id);
    return ResponseEntity.ok(dtoMapper.toDto(trabajador));
  }

  @Override
  public ResponseEntity<Void> create(TrabajadorDto trabajadorDto) {
    var trabajador = dtoMapper.toDomain(trabajadorDto);
    port.create(trabajador);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @Override
  public ResponseEntity<Void> update(Long id, TrabajadorDto trabajadorDto) {
    trabajadorDto.setId(id);
    var trabajador = dtoMapper.toDomain(trabajadorDto);
    port.update(trabajador);
    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity<Void> delete(Long id) {
    port.delete(id);
    return ResponseEntity.noContent().build();
  }
}

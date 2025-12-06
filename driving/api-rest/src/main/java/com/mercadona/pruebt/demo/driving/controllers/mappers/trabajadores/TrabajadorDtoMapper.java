package com.mercadona.pruebt.demo.driving.controllers.mappers.trabajadores;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.framework.cna.commons.rest.api.model.Pagination;
import com.mercadona.framework.cna.lib.web.builders.MercadonaPageResponseBuilder;
import com.mercadona.pruebt.demo.domain.pagination.PageRequest;
import com.mercadona.pruebt.demo.domain.products.Product;
import com.mercadona.pruebt.demo.domain.trabajadores.Trabajador;
import com.mercadona.pruebt.demo.driving.controllers.models.pagination.PageRequestDto;
import com.mercadona.pruebt.demo.driving.controllers.models.pagination.PageResponseDto;
import com.mercadona.pruebt.demo.driving.controllers.models.trabajadores.TrabajadorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = { MercadonaPageResponseBuilder.class })
public abstract class TrabajadorDtoMapper {

  @Autowired
  private MercadonaPageResponseBuilder mercadonaPageResponseBuilder;

  public abstract PageRequest toDomain(PageRequestDto pageRequestDto);

  @Mapping(source = ".", target = "pagination")
  @Mapping(source = "content", target = "data")
  public abstract PageResponseDto<TrabajadorDto> toDto(MercadonaPage<Trabajador> page);

  public Pagination toPagination(MercadonaPage<Product> page) {
    return mercadonaPageResponseBuilder
      .builder()
      .requestedPage(page.getNumber())
      .requestedSize(page.getSize())
      .retrievedResults(page.getNumberOfElements())
      .totalResults(page.getTotalElements())
      .buildNextPage(page.getNumber(), page.getSize(), page.getTotalPages())
      .buildPreviousPage(page.getNumber(), page.getSize())
      .build();
  }

  public abstract TrabajadorDto toDto(Trabajador trabajador);

  public abstract Trabajador toDomain(TrabajadorDto trabajadorDto);
}

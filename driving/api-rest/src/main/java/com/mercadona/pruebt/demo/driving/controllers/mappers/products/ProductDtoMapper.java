package com.mercadona.pruebt.demo.driving.controllers.mappers.products;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.framework.cna.commons.rest.api.model.Pagination;
import com.mercadona.framework.cna.lib.web.builders.MercadonaPageResponseBuilder;
import com.mercadona.pruebt.demo.domain.products.Product;
import com.mercadona.pruebt.demo.domain.products.ProductQuery;
import com.mercadona.pruebt.demo.driving.controllers.models.pagination.PageResponseDto;
import com.mercadona.pruebt.demo.driving.controllers.models.products.ProductDto;
import com.mercadona.pruebt.demo.driving.controllers.models.products.ProductQueryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = { MercadonaPageResponseBuilder.class })
public abstract class ProductDtoMapper {

  @Autowired
  private MercadonaPageResponseBuilder mercadonaPageResponseBuilder;

  public abstract ProductDto toDto(Product product);
  public abstract Product toDomain(ProductDto productDto);
  public abstract ProductQuery toDomain(ProductQueryDto queryDto);

  @Mapping(source = ".", target = "pagination")
  @Mapping(source = "content", target = "data")
  public abstract PageResponseDto<ProductDto> toDto(MercadonaPage<Product> page);

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
}

package com.mercadona.pruebt.demo.driving.controllers.adapters.products;

import com.mercadona.pruebt.demo.application.ports.driving.ProductPort;
import com.mercadona.pruebt.demo.driving.controllers.apis.ProductApi;
import com.mercadona.pruebt.demo.driving.controllers.mappers.products.ProductDtoMapper;
import com.mercadona.pruebt.demo.driving.controllers.models.pagination.PageResponseDto;
import com.mercadona.pruebt.demo.driving.controllers.models.products.ProductDto;
import com.mercadona.pruebt.demo.driving.controllers.models.products.ProductQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {

  private final ProductPort port;
  private final ProductDtoMapper mapper;

  @Override
  public ResponseEntity<PageResponseDto<ProductDto>> getAll(ProductQueryDto queryDto) {
    var query = mapper.toDomain(queryDto);
    var page = port.getAll(query);
    return ResponseEntity.ok(mapper.toDto(page));
  }

  @Override
  public ResponseEntity<ProductDto> getById(Long id) {
    var product = port.get(id);
    return ResponseEntity.ok(mapper.toDto(product));
  }

  @Override
  public ResponseEntity<Void> updateProduct(Long id, ProductDto productDto) {
    port.update(id, mapper.toDomain(productDto));
    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity<Void> patchProduct(Long id, ProductDto productDto) {
    port.patch(id, mapper.toDomain(productDto));
    return ResponseEntity.noContent().build();
  }
}

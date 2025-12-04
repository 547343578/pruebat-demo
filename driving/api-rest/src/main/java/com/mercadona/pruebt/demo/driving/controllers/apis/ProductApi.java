package com.mercadona.pruebt.demo.driving.controllers.apis;

import com.mercadona.pruebt.demo.driving.controllers.models.pagination.PageResponseDto;
import com.mercadona.pruebt.demo.driving.controllers.models.products.ProductQueryDto;
import com.mercadona.pruebt.demo.driving.controllers.models.products.ProductDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product api", description = "Product API")
@RequestMapping("/api/v1/products")
public interface ProductApi {

  @Operation(summary = "Get all products")
  @GetMapping
  @PreAuthorize("hasRole('ADMIN')")
  ResponseEntity<PageResponseDto<ProductDto>> getAll(ProductQueryDto queryDto);

  @Operation(summary = "Get one product by id")
  @GetMapping("/{id}")
  ResponseEntity<ProductDto> getById(@PathVariable Long id);

  @Operation(summary = "Update a product")
  @PutMapping("/{id}")
  ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody @Validated ProductDto productDto);

  @Operation(summary = "Patch update a product")
  @PatchMapping("/{id}")
  ResponseEntity<Void> patchProduct(@PathVariable Long id, @RequestBody ProductDto productDto);

  @Operation(summary = "Delete a product")
  @DeleteMapping("/{id}")
  ResponseEntity<Void> delete(@PathVariable Long id);

  @Operation(summary = "Delete all product by ids")
  @PostMapping("/delete")
  ResponseEntity<Void> delete(@RequestBody List<Long> ids);
}

package com.mercadona.pruebt.demo.driving.controllers.models.products;

import com.mercadona.pruebt.demo.driving.controllers.models.orders.OrderLineDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
  private Long id;
  private String name;
  private String description;
  @NotNull
  @PositiveOrZero
  private Float price;
  @NotNull
  private Integer stock;
  private OffsetDateTime createdAt;

  private Set<OrderLineDto> orderLines;
}

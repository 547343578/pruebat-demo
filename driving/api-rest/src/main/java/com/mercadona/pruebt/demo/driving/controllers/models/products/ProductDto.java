package com.mercadona.pruebt.demo.driving.controllers.models.products;

import com.mercadona.pruebt.demo.domain.orders.OrderLine;
import com.mercadona.pruebt.demo.driving.controllers.models.orders.OrderLineDto;
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
  private Float price;
  private Integer stock;
  private OffsetDateTime createdAt;

  private Set<OrderLineDto> orderLines;
}

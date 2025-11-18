package com.mercadona.pruebt.demo.domain.products;

import com.mercadona.pruebt.demo.domain.orders.OrderLine;
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
public class Product {
  private Long id;
  private String name;
  private String description;
  private Float price;
  private Integer stock;
  private OffsetDateTime createdAt;

  private Set<OrderLine> orderLines;
}

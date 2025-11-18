package com.mercadona.pruebt.demo.domain.orders;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderLine {
  private Long id;
  private Long orderId;
  private Long productId;
  private Integer quantity;
  private Float unitPrice;

  private Order order;
}

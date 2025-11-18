package com.mercadona.pruebt.demo.driving.controllers.models.orders;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
  private Long id;
  private String customerName;
  private String customerEmail;
  private String orderDate;
  private String status;
  private Float total;
}

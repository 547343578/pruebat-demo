package com.mercadona.pruebt.demo.driving.controllers.models.products;

import com.mercadona.pruebt.demo.driving.controllers.models.pagination.PageRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProductQueryDto extends PageRequestDto {
  private String name;
  private String description;
  private Float price;
}

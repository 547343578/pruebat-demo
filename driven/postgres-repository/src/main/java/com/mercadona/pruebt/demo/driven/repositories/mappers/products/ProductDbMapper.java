package com.mercadona.pruebt.demo.driven.repositories.mappers.products;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.pruebt.demo.domain.products.Product;
import com.mercadona.pruebt.demo.driven.repositories.mappers.orders.OrderDbMapper;
import com.mercadona.pruebt.demo.driven.repositories.models.products.ProductMO;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", uses = OrderDbMapper.class)
public interface ProductDbMapper {

  default MercadonaPage<Product> toDomain(Page<ProductMO> pageMO) {
    var page = pageMO.map(this::toDomain);
    return MercadonaPage.of(page);
  }

  Product toDomain(ProductMO productMO);

  ProductMO toDb(Product product);
}

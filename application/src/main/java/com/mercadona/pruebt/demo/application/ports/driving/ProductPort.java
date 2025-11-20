package com.mercadona.pruebt.demo.application.ports.driving;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.pruebt.demo.domain.products.Product;
import com.mercadona.pruebt.demo.domain.products.ProductQuery;

public interface ProductPort {
  MercadonaPage<Product> getAll(ProductQuery query);

  Product get(Long id);

  void update(Long id, Product product);

  void patch(Long id, Product product);
}

package com.mercadona.pruebt.demo.application.ports.driven;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.pruebt.demo.domain.products.Product;
import com.mercadona.pruebt.demo.domain.products.ProductQuery;

import java.util.List;
import java.util.Optional;

public interface ProductDbPort {
  MercadonaPage<Product> getAll(ProductQuery query);

  Optional<Product> get(Long id);

  void save(Product product);

  void delete(Long id);

  void deleteAll(List<Long> ids);
}

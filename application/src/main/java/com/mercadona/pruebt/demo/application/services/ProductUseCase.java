package com.mercadona.pruebt.demo.application.services;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.pruebt.demo.application.exceptions.ErrorCode;
import com.mercadona.pruebt.demo.application.exceptions.PruebatException;
import com.mercadona.pruebt.demo.application.lib.PatchUtils;
import com.mercadona.pruebt.demo.application.ports.driven.ProductDbPort;
import com.mercadona.pruebt.demo.application.ports.driving.ProductPort;
import com.mercadona.pruebt.demo.domain.products.Product;
import com.mercadona.pruebt.demo.domain.products.ProductQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductUseCase implements ProductPort {

  private final ProductDbPort dbPort;

  @Override
  @Transactional(readOnly = true)
  @Cacheable(value = "get-products")
  public MercadonaPage<Product> getAll(ProductQuery query) {
    return dbPort.getAll(query);
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(value = "get-product-id", key = "#id")
  public Product get(Long id) {
    return dbPort.get(id).orElseThrow(() -> new PruebatException(ErrorCode.PRODUCT_NOT_FOUND, id));
  }

  @Override
  @Transactional
  @Caching(evict = {
    @CacheEvict(value = { "get-product-id"}, key = "#id"),
    @CacheEvict(value = { "get-products" }, allEntries = true)
  })
  public void update(Long id, Product product) {
    product.setId(id);
    dbPort.save(product);
  }

  @Override
  @Transactional
  @Caching(evict = {
    @CacheEvict(value = { "get-product-id"}, key = "#id"),
    @CacheEvict(value = { "get-products" }, allEntries = true)
  })
  public void patch(Long id, Product product) {
    var existingProduct = dbPort.get(id).orElseThrow(() -> new PruebatException(ErrorCode.PRODUCT_NOT_FOUND, id));
    PatchUtils.patchObject(existingProduct, product);
    dbPort.save(existingProduct);
  }

  @Override
  @Transactional
  @Caching(evict = {
    @CacheEvict(value = { "get-product-id"}, key = "#id"),
    @CacheEvict(value = { "get-products" }, allEntries = true)
  })
  public void delete(Long id) {
    dbPort.delete(id);
  }

  @Override
  @Transactional
  @Caching(evict = {
    @CacheEvict(value = { "get-product-id"}, allEntries = true),
    @CacheEvict(value = { "get-products" }, allEntries = true)
  })
  public void deleteAll(List<Long> ids) {
    dbPort.deleteAll(ids);
  }
}

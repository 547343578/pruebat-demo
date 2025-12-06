package com.mercadona.pruebt.demo.application.ports.driving;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.pruebt.demo.domain.pagination.PageRequest;
import com.mercadona.pruebt.demo.domain.trabajadores.Trabajador;

public interface TrabajadorPort {
  MercadonaPage<Trabajador> getAll(PageRequest pageRequest);

  Trabajador getById(Long id);

  void create(Trabajador trabajador);

  void update(Trabajador trabajador);

  void delete(Long id);
}

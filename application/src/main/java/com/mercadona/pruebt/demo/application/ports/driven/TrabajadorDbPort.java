package com.mercadona.pruebt.demo.application.ports.driven;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.pruebt.demo.domain.pagination.PageRequest;
import com.mercadona.pruebt.demo.domain.trabajadores.Trabajador;

import java.util.Optional;

public interface TrabajadorDbPort {
  MercadonaPage<Trabajador> getAll(PageRequest pageRequest);

  Optional<Trabajador> getById(Long id);

  Long save(Trabajador trabajador);

  void delete(Long id);
}

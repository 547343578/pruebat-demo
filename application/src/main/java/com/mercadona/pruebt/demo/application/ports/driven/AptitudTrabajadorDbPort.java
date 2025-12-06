package com.mercadona.pruebt.demo.application.ports.driven;

import com.mercadona.pruebt.demo.domain.trabajadores.AptitudTrabajador;

import java.util.List;

public interface AptitudTrabajadorDbPort {
  void saveAll(List<AptitudTrabajador> aptitudTrabajadors);

  void deleteByTrabajadorId(Long id);
}

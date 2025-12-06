package com.mercadona.pruebt.demo.driven.repositories.repositories.tiendas;

import com.mercadona.pruebt.demo.driven.repositories.models.tiendas.AptitudTrabajadorMO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AptitudTrabajadorRepository extends JpaRepository<AptitudTrabajadorMO, Long> {
  void deleteByTrabajadorId(Long trabajadorId);
}

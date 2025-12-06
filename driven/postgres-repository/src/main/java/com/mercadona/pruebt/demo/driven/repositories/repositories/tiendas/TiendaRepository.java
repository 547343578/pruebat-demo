package com.mercadona.pruebt.demo.driven.repositories.repositories.tiendas;

import com.mercadona.pruebt.demo.driven.repositories.models.tiendas.TiendaMO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiendaRepository extends JpaRepository<TiendaMO, Long> {
}

package com.mercadona.pruebt.demo.driven.repositories.repositories.tiendas;

import com.mercadona.pruebt.demo.driven.repositories.models.tiendas.TrabajadorMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface TrabajadorRepository extends JpaRepository<TrabajadorMO, Long> {
  @Query("""
            SELECT DISTINCT t FROM TrabajadorMO t
            LEFT JOIN FETCH t.aptitudTrabajadores ats
            LEFT JOIN FETCH ats.aptitud
            WHERE t.id IN :ids
        """)
  Collection<TrabajadorMO> findAllByIdInWithAptitudes(List<Long> ids);
}

package com.mercadona.pruebt.demo.driven.repositories.adapters.tiendas;

import com.mercadona.pruebt.demo.application.ports.driven.AptitudDbPort;
import com.mercadona.pruebt.demo.domain.trabajadores.Aptitud;
import com.mercadona.pruebt.demo.driven.repositories.mappers.tiendas.AptitudDbMapper;
import com.mercadona.pruebt.demo.driven.repositories.models.tiendas.AptitudMO;
import com.mercadona.pruebt.demo.driven.repositories.repositories.tiendas.AptitudRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AptitudDbAdapter implements AptitudDbPort {

  private final AptitudRepository repository;

  private final AptitudDbMapper dbMapper;

  @Override
  public List<Aptitud> saveAll(List<Aptitud> aptitudes) {
    var mos = aptitudes.stream().map(dbMapper::toDb).toList();
    List<AptitudMO> mosSaved = repository.saveAll(mos);
    return mosSaved.stream().map(dbMapper::toDomain).toList();
  }
}

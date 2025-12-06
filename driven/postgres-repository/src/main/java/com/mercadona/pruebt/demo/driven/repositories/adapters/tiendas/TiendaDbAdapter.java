package com.mercadona.pruebt.demo.driven.repositories.adapters.tiendas;

import com.mercadona.pruebt.demo.application.ports.driven.TiendaDbPort;
import com.mercadona.pruebt.demo.driven.repositories.repositories.tiendas.TiendaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TiendaDbAdapter implements TiendaDbPort {

  private final TiendaRepository repository;

  @Override
  public boolean exists(Long tiendaId) {
    return repository.existsById(tiendaId);
  }
}

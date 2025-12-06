package com.mercadona.pruebt.demo.driven.repositories.adapters.tiendas;

import com.mercadona.pruebt.demo.application.ports.driven.AptitudTrabajadorDbPort;
import com.mercadona.pruebt.demo.domain.trabajadores.AptitudTrabajador;
import com.mercadona.pruebt.demo.driven.repositories.mappers.tiendas.AptitudDbMapper;
import com.mercadona.pruebt.demo.driven.repositories.repositories.tiendas.AptitudTrabajadorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AptitudTrabajadorDbAdapter implements AptitudTrabajadorDbPort {

  private final AptitudTrabajadorRepository repository;
  private final AptitudDbMapper dbMapper;

  @Override
  public void saveAll(List<AptitudTrabajador> aptitudTrabajadors) {
    var mos = aptitudTrabajadors.stream().map(dbMapper::toDb).toList();
    repository.saveAll(mos);
  }

  @Override
  public void deleteByTrabajadorId(Long id) {
    repository.deleteByTrabajadorId(id);
  }
}

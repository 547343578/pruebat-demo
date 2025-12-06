package com.mercadona.pruebt.demo.driven.repositories.adapters.tiendas;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.framework.cna.lib.repository.builders.MercadonaPageBuilder;
import com.mercadona.pruebt.demo.application.ports.driven.TrabajadorDbPort;
import com.mercadona.pruebt.demo.domain.pagination.PageRequest;
import com.mercadona.pruebt.demo.domain.trabajadores.Trabajador;
import com.mercadona.pruebt.demo.driven.repositories.mappers.tiendas.TrabajadorDbMapper;
import com.mercadona.pruebt.demo.driven.repositories.models.tiendas.TrabajadorMO;
import com.mercadona.pruebt.demo.driven.repositories.repositories.tiendas.TrabajadorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrabajadorDbAdapter implements TrabajadorDbPort {

  private final TrabajadorRepository repository;
  private final MercadonaPageBuilder mercadonaPageBuilder;

  private final TrabajadorDbMapper dbMapper;

  @Override
  public MercadonaPage<Trabajador> getAll(PageRequest pageRequest) {
    var pagination =  mercadonaPageBuilder.builder().page(pageRequest.getPage()).pageSize(pageRequest.getPageSize()).sort(pageRequest.getOrder()).build();
    var pageMOs = repository.findAll(pagination);
    var filteredIds = pageMOs.getContent().stream().map(TrabajadorMO::getId).toList();
    var trabajadoresMO = repository.findAllByIdInWithAptitudes(filteredIds);
    var trabajadorOrdered = getTrabajadoresOrdered(trabajadoresMO, filteredIds);
    var page = new PageImpl<>(trabajadorOrdered, pagination, pageMOs.getTotalElements());
    return MercadonaPage.of(page);
  }

  private List<Trabajador> getTrabajadoresOrdered(Collection<TrabajadorMO> trabajadorMOS, List<Long> filteredIds) {
    Map<Long, TrabajadorMO> trabajadoreById = trabajadorMOS.stream().collect(Collectors.toMap(TrabajadorMO::getId, Function.identity()));
    return filteredIds.stream()
      .map(trabajadoreById::get)
      .filter(Objects::nonNull)
      .map(dbMapper::toDomain)
      .collect(Collectors.toList());
  }

  @Override
  public Optional<Trabajador> getById(Long id) {
    return repository.findById(id)
      .map(dbMapper::toDomain);
  }

  @Override
  public Long save(Trabajador trabajador) {
    var mo = repository.save(dbMapper.toDb(trabajador));
    return mo.getId();
  }

  @Override
  public void delete(Long id) {
    repository.deleteById(id);
  }
}

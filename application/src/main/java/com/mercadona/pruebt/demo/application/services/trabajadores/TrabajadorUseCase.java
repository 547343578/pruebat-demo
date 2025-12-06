package com.mercadona.pruebt.demo.application.services.trabajadores;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.pruebt.demo.application.exceptions.ErrorCode;
import com.mercadona.pruebt.demo.application.exceptions.PruebatException;
import com.mercadona.pruebt.demo.application.ports.driven.TiendaDbPort;
import com.mercadona.pruebt.demo.application.ports.driven.TrabajadorDbPort;
import com.mercadona.pruebt.demo.application.ports.driving.TrabajadorPort;
import com.mercadona.pruebt.demo.domain.pagination.PageRequest;
import com.mercadona.pruebt.demo.domain.trabajadores.Trabajador;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrabajadorUseCase implements TrabajadorPort {

  private final TrabajadorDbPort dbPort;
  private final TiendaDbPort tiendaDbPort;

  private final AptitudService aptitudService;

  @Override
  @Transactional(readOnly = true)
  public MercadonaPage<Trabajador> getAll(PageRequest pageRequest) {
    return dbPort.getAll(pageRequest);
  }

  @Override
  @Transactional(readOnly = true)
  public Trabajador getById(Long id) {
    return dbPort.getById(id).orElseThrow(() -> new PruebatException(ErrorCode.TRABAJADOR_NOT_EXISTS, id));
  }

  @Override
  @Transactional
  public void create(Trabajador trabajador) {
    checkIfTiendaExists(trabajador);
    Long trabajadorId = dbPort.save(trabajador);
    //aptitudService.save(trabajadorId, trabajador.getAptitudes());
  }

  @Override
  @Transactional
  public void update(Trabajador trabajador) {
    checkIfTiendaExists(trabajador);
    dbPort.save(trabajador);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    aptitudService.deleteByTrabajadorId(id);
    dbPort.delete(id);
  }

  private void checkIfTiendaExists(Trabajador trabajador) {
    if (!tiendaDbPort.exists(trabajador.getTiendaId())) throw new PruebatException(ErrorCode.TIENDA_NOT_EXISTS, trabajador.getTiendaId());
  }
}

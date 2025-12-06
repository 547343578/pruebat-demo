package com.mercadona.pruebt.demo.application.services.trabajadores;

import com.mercadona.pruebt.demo.application.ports.driven.AptitudDbPort;
import com.mercadona.pruebt.demo.application.ports.driven.AptitudTrabajadorDbPort;
import com.mercadona.pruebt.demo.domain.trabajadores.Aptitud;
import com.mercadona.pruebt.demo.domain.trabajadores.AptitudTrabajador;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AptitudService {

  private final AptitudTrabajadorDbPort aptitudTrabajadorDbPort;
  private final AptitudDbPort aptitudDbPort;

  public void save(Long trabajadorId, List<Aptitud> aptitudes) {
    if (aptitudes != null && !aptitudes.isEmpty()) {
      var aptituds = aptitudDbPort.saveAll(aptitudes);
      var aptitudTrabajadors = aptituds.stream().map(a -> new AptitudTrabajador(null, trabajadorId, a.getId())).toList();
      aptitudTrabajadorDbPort.saveAll(aptitudTrabajadors);
    }
  }

  public void deleteByTrabajadorId(Long id) {
    aptitudTrabajadorDbPort.deleteByTrabajadorId(id);
  }
}

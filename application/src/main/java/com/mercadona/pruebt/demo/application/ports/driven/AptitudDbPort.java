package com.mercadona.pruebt.demo.application.ports.driven;

import com.mercadona.pruebt.demo.domain.trabajadores.Aptitud;

import java.util.List;

public interface AptitudDbPort {
  List<Aptitud> saveAll(List<Aptitud> aptitudes);
}

package com.mercadona.pruebt.demo.driven.repositories.mappers.tiendas;

import com.mercadona.pruebt.demo.domain.trabajadores.Aptitud;
import com.mercadona.pruebt.demo.domain.trabajadores.AptitudTrabajador;
import com.mercadona.pruebt.demo.driven.repositories.models.tiendas.AptitudMO;
import com.mercadona.pruebt.demo.driven.repositories.models.tiendas.AptitudTrabajadorMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AptitudDbMapper {
  AptitudTrabajadorMO toDb(AptitudTrabajador aptitudTrabajador);
  AptitudMO toDb(Aptitud aptitud);

  Aptitud toDomain(AptitudMO aptitudMO);
}

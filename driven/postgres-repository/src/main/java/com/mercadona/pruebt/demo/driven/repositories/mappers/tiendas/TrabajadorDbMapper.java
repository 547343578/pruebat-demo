package com.mercadona.pruebt.demo.driven.repositories.mappers.tiendas;

import com.mercadona.pruebt.demo.domain.trabajadores.Aptitud;
import com.mercadona.pruebt.demo.domain.trabajadores.Trabajador;
import com.mercadona.pruebt.demo.driven.repositories.models.tiendas.AptitudMO;
import com.mercadona.pruebt.demo.driven.repositories.models.tiendas.AptitudTrabajadorMO;
import com.mercadona.pruebt.demo.driven.repositories.models.tiendas.TrabajadorMO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrabajadorDbMapper {
  @Mapping(source = "aptitudTrabajadores", target = "aptitudes", qualifiedByName = "mapAptitudes")
  Trabajador toDomain(TrabajadorMO trabajadorMO);

  Aptitud toDomain(AptitudMO aptitudMO);

  @Named("mapAptitudes")
  default List<Aptitud> mapAptitudes(List<AptitudTrabajadorMO> aptitudTrabajadorMOS) {
    return aptitudTrabajadorMOS.stream().map(AptitudTrabajadorMO::getAptitud).map(this::toDomain).toList();
  }

  TrabajadorMO toDb(Trabajador trabajador);
}

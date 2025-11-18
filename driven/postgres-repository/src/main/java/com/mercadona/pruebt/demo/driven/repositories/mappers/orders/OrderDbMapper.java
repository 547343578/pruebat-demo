package com.mercadona.pruebt.demo.driven.repositories.mappers.orders;

import com.mercadona.pruebt.demo.domain.orders.Order;
import com.mercadona.pruebt.demo.domain.orders.OrderLine;
import com.mercadona.pruebt.demo.driven.repositories.models.orders.OrderLineMO;
import com.mercadona.pruebt.demo.driven.repositories.models.orders.OrderMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderDbMapper {

  Order toDomain(OrderMO orderMO);

  OrderLine toDomain(OrderLineMO orderLineMO);
}

package com.mercadona.pruebt.demo.driven.repositories.mappers.users;

import com.mercadona.pruebt.demo.domain.users.Role;
import com.mercadona.pruebt.demo.domain.users.User;
import com.mercadona.pruebt.demo.driven.repositories.models.UserMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDbMapper {

  User toDomain(UserMO userMO);

  default Role toDomain(String role) {
    return Role.getRole(role);
  }
}

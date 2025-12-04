package com.mercadona.pruebt.demo.driven.repositories.adapters;

import com.mercadona.pruebt.demo.application.exceptions.ErrorCode;
import com.mercadona.pruebt.demo.application.exceptions.PruebatException;
import com.mercadona.pruebt.demo.application.ports.driven.UserDbPort;
import com.mercadona.pruebt.demo.domain.users.Role;
import com.mercadona.pruebt.demo.domain.users.User;
import com.mercadona.pruebt.demo.driven.repositories.UserRepository;
import com.mercadona.pruebt.demo.driven.repositories.mappers.users.UserDbMapper;
import com.mercadona.pruebt.demo.driven.repositories.models.UserMO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDbAdapter implements UserDbPort {

  private final UserRepository repository;

  private final UserDbMapper dbMapper;

  @Override
  public boolean isRegistered(String username, String password) {
    return repository.isRegistered(username, password);
  }

  @Override
  public User get(String username) {
    return repository.findById(username)
      .map(dbMapper::toDomain)
      .orElseThrow(() -> new PruebatException(ErrorCode.NOT_REGISTERED, username));
  }
}

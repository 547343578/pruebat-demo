package com.mercadona.pruebt.demo.driven.repositories.adapters;

import com.mercadona.pruebt.demo.application.ports.driven.UserDbPort;
import com.mercadona.pruebt.demo.domain.users.User;
import com.mercadona.pruebt.demo.driven.repositories.repositories.UserRepository;
import com.mercadona.pruebt.demo.driven.repositories.mappers.users.UserDbMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDbAdapter implements UserDbPort {

  private final UserRepository repository;

  private final UserDbMapper dbMapper;

  @Override
  public Optional<User> get(String username, String password) {
    return repository.getUser(username, password)
      .map(dbMapper::toDomain);
  }
}

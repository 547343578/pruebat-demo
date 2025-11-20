package com.mercadona.pruebt.demo.driven.repositories.adapters;

import com.mercadona.pruebt.demo.application.ports.driven.UserDbPort;
import com.mercadona.pruebt.demo.driven.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDbAdapter implements UserDbPort {

  private final UserRepository repository;

  @Override
  public boolean isRegistered(String username, String password) {
    return repository.isRegistered(username, password);
  }
}

package com.mercadona.pruebt.demo.application.ports.driven;

import com.mercadona.pruebt.demo.domain.users.User;

import java.util.Optional;

public interface UserDbPort {
  Optional<User> get(String username, String password);
}

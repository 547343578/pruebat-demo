package com.mercadona.pruebt.demo.application.ports.driven;

import com.mercadona.pruebt.demo.domain.users.Role;
import com.mercadona.pruebt.demo.domain.users.User;

public interface UserDbPort {

  boolean isRegistered(String username, String password);
  User get(String username);
}

package com.mercadona.pruebt.demo.application.services;

import com.mercadona.pruebt.demo.application.exceptions.AuthorizationException;
import com.mercadona.pruebt.demo.application.exceptions.ErrorCode;
import com.mercadona.pruebt.demo.application.ports.driven.UserDbPort;
import com.mercadona.pruebt.demo.domain.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserDbPort userDbPort;

  public User getUser(String username, String password) {
    return userDbPort.get(username, password).orElseThrow(() -> new AuthorizationException(ErrorCode.NOT_REGISTERED, username));
  }
}

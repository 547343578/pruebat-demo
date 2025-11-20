package com.mercadona.pruebt.demo.application.services;

import com.mercadona.pruebt.demo.application.ports.driven.UserDbPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserDbPort userDbPort;

  public boolean isRegistered(String username, String pasword) {
    return userDbPort.isRegistered(username, pasword);
  }
}

package com.mercadona.pruebt.demo.application.services;

import com.mercadona.pruebt.demo.application.exceptions.ErrorCode;
import com.mercadona.pruebt.demo.application.exceptions.PruebatException;
import com.mercadona.pruebt.demo.application.lib.JwtUtils;
import com.mercadona.pruebt.demo.application.ports.driving.AuthenticationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationUseCase implements AuthenticationPort {

  private final UserService userService;

  @Override
  public String login(String username, String password) {
    var isRegistered = userService.isRegistered(username, password);
    if (!isRegistered) {
      throw new PruebatException(ErrorCode.NOT_REGISTERED, username);
    }
    return JwtUtils.generateToken(username);
  }
}

package com.mercadona.pruebt.demo.driving.controllers.adapters.auths;

import com.mercadona.pruebt.demo.application.ports.driving.AuthenticationPort;
import com.mercadona.pruebt.demo.driving.controllers.apis.AuthenticationApi;
import com.mercadona.pruebt.demo.driving.controllers.models.auths.LoginRequestDto;
import com.mercadona.pruebt.demo.driving.controllers.models.auths.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController implements AuthenticationApi {

  private final AuthenticationPort port;

  @Override
  public LoginResponseDto login(LoginRequestDto requestDto) {
    var token = port.login(requestDto.getUsername(), requestDto.getPassword());
    return new LoginResponseDto(token);
  }
}

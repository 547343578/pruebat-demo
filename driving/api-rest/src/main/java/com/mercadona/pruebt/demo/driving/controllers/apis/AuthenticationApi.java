package com.mercadona.pruebt.demo.driving.controllers.apis;

import com.mercadona.pruebt.demo.driving.controllers.models.auths.LoginRequestDto;
import com.mercadona.pruebt.demo.driving.controllers.models.auths.LoginResponseDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface AuthenticationApi {

  @PostMapping("/login")
  LoginResponseDto login(@RequestBody @Validated LoginRequestDto requestDto);

}

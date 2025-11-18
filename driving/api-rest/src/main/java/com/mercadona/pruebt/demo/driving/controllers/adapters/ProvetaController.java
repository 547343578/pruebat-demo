package com.mercadona.pruebt.demo.driving.controllers.adapters;

import com.mercadona.pruebt.demo.driving.controllers.apis.ProvetaApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProvetaController implements ProvetaApi {

  @Override
  public String hello() {
    return "hello";
  }
}

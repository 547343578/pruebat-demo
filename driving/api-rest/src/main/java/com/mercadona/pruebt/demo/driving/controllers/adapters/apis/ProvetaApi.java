package com.mercadona.pruebt.demo.driving.controllers.adapters.apis;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Echo api", description = "Echo API")
@RequestMapping("/api/v1")
public interface ProvetaApi {

  @Operation(summary = "Says hello")
  @GetMapping("/echo")
  String hello();
}

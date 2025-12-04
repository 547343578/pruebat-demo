package com.mercadona.pruebt.demo.domain.users;


import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public enum Role {
  ADMIN("ADMIN"),
  USER("USER"),
  GUEST("GUEST");

  private final String code;

  private static final Map<String, Role> formats;

  static {
    formats = Arrays.stream(values()).collect(Collectors.toMap(Role::getCode, Function.identity()));
  }

  Role(String code){
    this.code = code;
  }

  public static Role getRole(String code){
    return Optional.ofNullable(formats.get(code)).orElse(GUEST);
  }
}

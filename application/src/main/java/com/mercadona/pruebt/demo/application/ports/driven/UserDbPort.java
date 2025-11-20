package com.mercadona.pruebt.demo.application.ports.driven;

public interface UserDbPort {

  boolean isRegistered(String username, String password);

}

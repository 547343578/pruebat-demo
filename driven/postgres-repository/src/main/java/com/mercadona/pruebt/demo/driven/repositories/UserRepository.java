package com.mercadona.pruebt.demo.driven.repositories;

import aj.org.objectweb.asm.commons.Remapper;
import com.mercadona.pruebt.demo.driven.repositories.models.UserMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserMO, String> {

  @Query("""
    SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END
    FROM UserMO u
    WHERE u.username = :username AND u.password = :password
    """)
  boolean isRegistered(String username, String password);

  @Query("""
    SELECT u
    FROM UserMO u
    WHERE u.username = :username AND u.password = :password
    """)
  Optional<UserMO> getUser(String username, String password);
}

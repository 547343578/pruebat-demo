package com.mercadona.pruebt.demo.driven.repositories.repositories;

import com.mercadona.pruebt.demo.driven.repositories.models.ExampleMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleMOJpaRepository extends JpaRepository<ExampleMO, Long> { }

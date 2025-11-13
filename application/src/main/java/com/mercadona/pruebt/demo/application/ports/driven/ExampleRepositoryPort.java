package com.mercadona.pruebt.demo.application.ports.driven;

import com.mercadona.framework.cna.commons.interfaces.CNACrudRepository;
import com.mercadona.pruebt.demo.domain.Example;

public interface ExampleRepositoryPort extends CNACrudRepository<Example, Long> { }

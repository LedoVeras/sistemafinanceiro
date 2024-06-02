package com.ledo.sistemafinanceiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface EntityRepository<T, ID> extends JpaRepository<T, ID> {

    List<T> findByAtivoTrue();

    Optional<T> findAtivoById(ID id);

}

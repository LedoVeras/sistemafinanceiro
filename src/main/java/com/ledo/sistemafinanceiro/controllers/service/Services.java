package com.ledo.sistemafinanceiro.controllers.service;

import com.ledo.sistemafinanceiro.entidades.entity.SFEntity;
import com.ledo.sistemafinanceiro.repositories.EntityRepository;

import java.util.Optional;

public class Services {

    public static <T> T findObjectById(EntityRepository<T,Long> repository, Long id) {
        Optional<T> entity = repository.findAtivoById(id);
        return entity.orElseThrow();
    }

    public static <T extends SFEntity> void logicDelete(EntityRepository<T,Long> repository, Long id) {
        T entity = findObjectById(repository, id);
        entity.setAtivo(false);
        repository.save(entity);
    }
}

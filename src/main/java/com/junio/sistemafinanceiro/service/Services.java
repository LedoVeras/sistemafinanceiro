package com.junio.sistemafinanceiro.service;

import com.junio.sistemafinanceiro.entidades.entity.SFEntity;
import com.junio.sistemafinanceiro.repositories.EntityRepository;

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

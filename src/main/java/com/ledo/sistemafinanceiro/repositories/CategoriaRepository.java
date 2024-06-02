package com.ledo.sistemafinanceiro.repositories;

import com.ledo.sistemafinanceiro.entidades.categoria.Categoria;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends EntityRepository<Categoria, Long> {

    boolean existsByNome(String nome);
}

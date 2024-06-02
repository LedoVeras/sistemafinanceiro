package com.junio.sistemafinanceiro.repositories;

import com.junio.sistemafinanceiro.entidades.categoria.Categoria;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends EntityRepository<Categoria, Long> {

    boolean existsByNome(String nome);
}

package com.ledo.sistemafinanceiro.repositories;

import com.ledo.sistemafinanceiro.entidades.pessoa.Pessoa;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends EntityRepository<Pessoa, Long> {

}

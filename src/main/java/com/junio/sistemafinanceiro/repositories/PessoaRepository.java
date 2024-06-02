package com.junio.sistemafinanceiro.repositories;

import com.junio.sistemafinanceiro.entidades.pessoa.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends EntityRepository<Pessoa, Long> {

}

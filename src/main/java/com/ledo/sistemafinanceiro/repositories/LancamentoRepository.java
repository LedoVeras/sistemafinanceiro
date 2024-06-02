package com.ledo.sistemafinanceiro.repositories;

import com.ledo.sistemafinanceiro.entidades.lancamento.Lancamento;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends EntityRepository<Lancamento, Long> {

}

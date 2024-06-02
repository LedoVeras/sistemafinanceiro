package com.junio.sistemafinanceiro.repositories;

import com.junio.sistemafinanceiro.entidades.lancamento.Lancamento;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LancamentoRepository extends EntityRepository<Lancamento, Long> {

}

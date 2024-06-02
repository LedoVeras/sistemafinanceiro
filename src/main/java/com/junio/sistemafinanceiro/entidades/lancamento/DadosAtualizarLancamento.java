package com.junio.sistemafinanceiro.entidades.lancamento;

import com.junio.sistemafinanceiro.entidades.categoria.Categoria;
import com.junio.sistemafinanceiro.service.exceptions.DadoInvalidoException;

import java.time.Instant;

public record DadosAtualizarLancamento(
        String descricao,
        String observacao,
        Double valor,
        Instant dataVencimento,
        Categoria categoria,
        Boolean transacaoConcluida
) {
}

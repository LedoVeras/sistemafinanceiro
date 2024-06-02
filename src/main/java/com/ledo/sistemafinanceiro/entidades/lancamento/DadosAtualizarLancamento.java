package com.ledo.sistemafinanceiro.entidades.lancamento;

import com.ledo.sistemafinanceiro.entidades.categoria.Categoria;

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

package com.ledo.sistemafinanceiro.entidades.lancamento;

import com.ledo.sistemafinanceiro.entidades.categoria.Categoria;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record DadosAtualizarLancamento(
        String descricao,
        String observacao,
        Double valor,
        Instant dataVencimento,
        Long idCategoria,
        Long idPessoa,
        Boolean transacaoConcluida
) {
}

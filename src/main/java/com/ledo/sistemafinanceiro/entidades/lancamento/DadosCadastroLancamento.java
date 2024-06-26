package com.ledo.sistemafinanceiro.entidades.lancamento;

import com.ledo.sistemafinanceiro.entidades.lancamento.enums.TipoLancamento;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroLancamento(
        @NotBlank
        String descricao,
        @Nullable
        String observacao,
        @NotNull
        Double valor,
        @NotNull
        TipoLancamento tipoLancamento,
        @NotNull
        Long idPessoa,
        @NotNull
        Long idCategoria,
        Boolean transacaoConcluida
) {
}

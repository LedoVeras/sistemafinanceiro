package com.ledo.sistemafinanceiro.entidades.pessoa;

import com.ledo.sistemafinanceiro.entidades.endereco.EnderecoData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

public record DadosAtualizarPessoa(

        @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
        String nome,

        @Valid
        EnderecoData endereco) {
}

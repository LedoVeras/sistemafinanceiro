package com.ledo.sistemafinanceiro.entidades.endereco;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EnderecoData(
        @Size(min = 3, max = 100, message = "Logradouro deve ter entre 3 e 100 caracteres")
        String logradouro,

        @Size(min = 3, max = 100, message = "Bairro deve ter entre 3 e 100 caracteres")
        String bairro,
        @Size(max = 100, message = "Complemento deve ter no máximo 100 caracteres")
        String complemento,
        @Size(min = 3, max = 100, message = "Cidade deve ter entre 3 e 100 caracteres")
        String cidade,

        @Pattern(regexp = "^[0-9]{5}-?[0-9]{3}$", message = "CEP deve estar no formato 12345-678 ou 12345678")
        String cep,

        @Size(min = 2, max = 2, message = "Uf deve ter 2 caracteres")
        String uf,

        @Pattern(regexp = "^\\d+$", message = "Número deve ser um número")
        @Size(max = 20, message = "Número deve ter no máximo 20 caracteres")
        String numero
) {}

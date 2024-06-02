package com.ledo.sistemafinanceiro.entidades.endereco;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String cep;
    private String cidade;
    private String uf;
    private String logradouro;
    private String bairro;
    private String complemento;
    private String numero;

    public Endereco(EnderecoData dados) {
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.complemento = dados.complemento();
        this.numero = dados.numero();
    }

}
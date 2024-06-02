package com.ledo.sistemafinanceiro.entidades.pessoa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ledo.sistemafinanceiro.entidades.endereco.Endereco;
import com.ledo.sistemafinanceiro.entidades.entity.SFEntity;
import com.ledo.sistemafinanceiro.entidades.lancamento.Lancamento;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Pessoa")
@Table(name = "Pessoas")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id", callSuper = false)
public class Pessoa extends SFEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @JsonIgnore
    private Boolean ativo;

    @Embedded
    private Endereco endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoa")
    private List<Lancamento> lancamentos = new ArrayList<>();

    public Pessoa(DadosCadastroPessoa dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.endereco = new Endereco(dados.endereco());
    }
}

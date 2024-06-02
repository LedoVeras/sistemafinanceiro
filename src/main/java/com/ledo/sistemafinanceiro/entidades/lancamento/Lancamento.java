package com.ledo.sistemafinanceiro.entidades.lancamento;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ledo.sistemafinanceiro.entidades.categoria.Categoria;
import com.ledo.sistemafinanceiro.entidades.entity.SFEntity;
import com.ledo.sistemafinanceiro.entidades.lancamento.enums.TipoLancamento;
import com.ledo.sistemafinanceiro.entidades.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.ZoneId;

@Entity(name = "Lancamento")
@Table(name = "Lancamentos")
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id", callSuper = false)
public class Lancamento extends SFEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private String observacao;

    private Double valor;

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd",
            timezone = "GMT")
    private Instant dataVencimento;

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd",
            timezone = "GMT")
    private Instant dataPagamento;

    @ManyToOne
    private Categoria categoria = new Categoria();

    @Enumerated(EnumType.STRING)
    private TipoLancamento tipoLancamento;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @JsonIgnore
    private Boolean ativo;

    public Lancamento(DadosCadastroLancamento dados) {
        this.ativo = true;
        this.descricao = dados.descricao();
        this.observacao = dados.observacao();
        this.valor = dados.valor();
        this.tipoLancamento = dados.tipoLancamento();
        this.dataVencimento = Instant.now().atZone(ZoneId.systemDefault()).plusDays(30).toInstant();

        if(dados.transacaoConcluida() != null)
            this.dataPagamento = dados.transacaoConcluida() ? Instant.now() : null;
    }

}

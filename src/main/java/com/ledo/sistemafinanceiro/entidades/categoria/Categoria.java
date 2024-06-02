package com.ledo.sistemafinanceiro.entidades.categoria;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ledo.sistemafinanceiro.entidades.entity.SFEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Categoria")
@Table(name = "Categorias")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id", callSuper = false)
public class Categoria extends SFEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @JsonIgnore
    private Boolean ativo;

    public Categoria(DadosCadastroCategoria dados) {
        this.ativo = true;
        this.nome = dados.nome();
    }
}

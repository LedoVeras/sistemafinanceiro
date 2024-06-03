package com.ledo.sistemafinanceiro.controllers.service;

import com.ledo.sistemafinanceiro.entidades.lancamento.DadosAtualizarLancamento;
import com.ledo.sistemafinanceiro.entidades.lancamento.DadosCadastroLancamento;
import com.ledo.sistemafinanceiro.entidades.lancamento.Lancamento;
import com.ledo.sistemafinanceiro.repositories.CategoriaRepository;
import com.ledo.sistemafinanceiro.repositories.LancamentoRepository;
import com.ledo.sistemafinanceiro.repositories.PessoaRepository;
import com.ledo.sistemafinanceiro.controllers.service.utils.Updater;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class LancamentoService {

    private final LancamentoRepository lancamentoRepository;
    private final PessoaRepository pessoaRepository;
    private final CategoriaRepository categoriaRepository;

    // Create
    public Lancamento createLancamento(DadosCadastroLancamento dados) {

        var lancamento = new Lancamento(dados);

        lancamento.setPessoa(Services.findObjectById(pessoaRepository, dados.idPessoa()));
        lancamento.setCategoria(Services.findObjectById(categoriaRepository, dados.idCategoria()));

        return lancamentoRepository.save(lancamento);
    }

    // Read
    public List<Lancamento> findAllLancamentos() {
        return lancamentoRepository.findByAtivoTrue();
    }

    public Lancamento findLancamentoById(Long id) {
        return Services.findObjectById(lancamentoRepository, id);
    }

    // Update
    public Lancamento updateLancamento(Long id, DadosAtualizarLancamento dados) {
        Lancamento lancamento = Services.findObjectById(lancamentoRepository, id);

        Updater.update(lancamento, dados);

        if (dados.transacaoConcluida() != null) {
            lancamento.setDataPagamento(dados.transacaoConcluida() ? Instant.now() : null);
        }

        if(dados.idCategoria() != null){
            lancamento.setCategoria(Services.findObjectById(categoriaRepository, dados.idCategoria()));
        }

        if(dados.idPessoa() != null){
            lancamento.setPessoa(Services.findObjectById(pessoaRepository, dados.idPessoa()));
        }

        return lancamentoRepository.save(lancamento);
    }

    // Delete
    public void deleteLogicoLancamento(Long id) {
        Services.logicDelete(lancamentoRepository, id);
    }
}

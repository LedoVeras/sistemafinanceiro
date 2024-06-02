package com.junio.sistemafinanceiro.controllers.service;

import com.junio.sistemafinanceiro.entidades.lancamento.DadosAtualizarLancamento;
import com.junio.sistemafinanceiro.entidades.lancamento.DadosCadastroLancamento;
import com.junio.sistemafinanceiro.entidades.lancamento.Lancamento;
import com.junio.sistemafinanceiro.repositories.CategoriaRepository;
import com.junio.sistemafinanceiro.repositories.LancamentoRepository;
import com.junio.sistemafinanceiro.repositories.PessoaRepository;
import com.junio.sistemafinanceiro.controllers.service.utils.Updater;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

import static com.junio.sistemafinanceiro.controllers.service.Services.findObjectById;
import static com.junio.sistemafinanceiro.controllers.service.Services.logicDelete;

@Service
@AllArgsConstructor
public class LancamentoService {

    private final LancamentoRepository lancamentoRepository;
    private final PessoaRepository pessoaRepository;
    private final CategoriaRepository categoriaRepository;

    // Create
    public Lancamento createLancamento(DadosCadastroLancamento dados) {

        var lancamento = new Lancamento(dados);

        lancamento.setPessoa(findObjectById(pessoaRepository, dados.idPessoa()));
        lancamento.setCategoria(findObjectById(categoriaRepository, dados.idCategoria()));

        return lancamentoRepository.save(lancamento);
    }

    // Read
    public List<Lancamento> findAllLancamentos() {
        return lancamentoRepository.findByAtivoTrue();
    }

    public Lancamento findLancamentoById(Long id) {
        return findObjectById(lancamentoRepository, id);
    }

    // Update
    public Lancamento updateLancamento(Long id, DadosAtualizarLancamento dados) {
        Lancamento lancamento = findObjectById(lancamentoRepository, id);

        Updater.update(lancamento, dados);

        if (dados.transacaoConcluida() != null) {
            lancamento.setDataPagamento(dados.transacaoConcluida() ? Instant.now() : null);
        }

        return lancamentoRepository.save(lancamento);
    }

    // Delete
    public void deleteLogicoLancamento(Long id) {
        logicDelete(lancamentoRepository, id);
    }
}

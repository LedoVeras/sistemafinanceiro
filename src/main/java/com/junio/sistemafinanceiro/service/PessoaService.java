package com.junio.sistemafinanceiro.service;

import com.junio.sistemafinanceiro.entidades.pessoa.DadosAtualizarPessoa;
import com.junio.sistemafinanceiro.entidades.pessoa.DadosCadastroPessoa;
import com.junio.sistemafinanceiro.entidades.pessoa.Pessoa;
import com.junio.sistemafinanceiro.repositories.PessoaRepository;
import com.junio.sistemafinanceiro.service.utils.Updater;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.junio.sistemafinanceiro.service.Services.findObjectById;
import static com.junio.sistemafinanceiro.service.Services.logicDelete;

@Service
@AllArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    // Create
    public Pessoa createPessoa(DadosCadastroPessoa dados) {
        var pessoa = new Pessoa(dados);
        return pessoaRepository.save(pessoa);
    }

    // Read
    public List<Pessoa> findAllPessoas() {
        return pessoaRepository.findByAtivoTrue();
    }

    public Pessoa findPessoaById(Long id) {
        return findObjectById(pessoaRepository, id);
    }

    // Update
    public Pessoa updatePessoa(Long id, DadosAtualizarPessoa dados) {
        var pessoa = findObjectById(pessoaRepository, id);

        Updater.update(pessoa, dados);

        return pessoaRepository.save(pessoa);
    }

    // Delete
    public void deleteLogicoPessoa(Long id) {
        logicDelete(pessoaRepository, id);
    }
}

package com.ledo.sistemafinanceiro.controllers.service;

import com.ledo.sistemafinanceiro.controllers.service.utils.Updater;
import com.ledo.sistemafinanceiro.entidades.pessoa.DadosAtualizarPessoa;
import com.ledo.sistemafinanceiro.entidades.pessoa.DadosCadastroPessoa;
import com.ledo.sistemafinanceiro.entidades.pessoa.Pessoa;
import com.ledo.sistemafinanceiro.repositories.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return Services.findObjectById(pessoaRepository, id);
    }

    // Update
    public Pessoa updatePessoa(Long id, DadosAtualizarPessoa dados) {
        var pessoa = Services.findObjectById(pessoaRepository, id);

        Updater.update(pessoa, dados);

        return pessoaRepository.save(pessoa);
    }

    // Delete
    public void deleteLogicoPessoa(Long id) {
        Services.logicDelete(pessoaRepository, id);
    }
}

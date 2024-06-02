package com.junio.sistemafinanceiro.service;

import com.junio.sistemafinanceiro.entidades.categoria.Categoria;
import com.junio.sistemafinanceiro.entidades.categoria.DadosCadastroCategoria;
import com.junio.sistemafinanceiro.repositories.CategoriaRepository;
import com.junio.sistemafinanceiro.entidades.categoria.DadosAtualizarCategoria;
import com.junio.sistemafinanceiro.service.exceptions.CategoriaJaExistenteException;
import com.junio.sistemafinanceiro.service.utils.Updater;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.junio.sistemafinanceiro.service.Services.findObjectById;
import static com.junio.sistemafinanceiro.service.Services.logicDelete;

@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    // Create
    public Categoria createCategoria(DadosCadastroCategoria dados) {
        String nome = dados.nome();

        if (categoriaRepository.existsByNome(nome)) {
            throw new CategoriaJaExistenteException();
        }

        Categoria categoria = new Categoria(dados);
        return categoriaRepository.save(categoria);
    }

    // Read
    public List<Categoria> findAllCategorias() {
        return categoriaRepository.findByAtivoTrue();
    }

    public Categoria findCategoriaById(Long id) {return findObjectById(categoriaRepository, id);}

    // Update
    public Categoria updateCategoria(Long id, DadosAtualizarCategoria dados) {
        var categoria = findObjectById(categoriaRepository, id);

        Updater.update(categoria, dados);

        return categoriaRepository.save(categoria);
    }

    // Delete
    public void deleteLogicoCategoria(Long id) {
        logicDelete(categoriaRepository, id);
    }
}

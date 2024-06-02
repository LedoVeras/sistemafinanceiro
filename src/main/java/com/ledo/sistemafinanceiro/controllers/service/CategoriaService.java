package com.ledo.sistemafinanceiro.controllers.service;

import com.ledo.sistemafinanceiro.entidades.categoria.Categoria;
import com.ledo.sistemafinanceiro.entidades.categoria.DadosCadastroCategoria;
import com.ledo.sistemafinanceiro.repositories.CategoriaRepository;
import com.ledo.sistemafinanceiro.entidades.categoria.DadosAtualizarCategoria;
import com.ledo.sistemafinanceiro.controllers.service.utils.Updater;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    // Create
    public Categoria createCategoria(DadosCadastroCategoria dados) {
        Categoria categoria = new Categoria(dados);
        return categoriaRepository.save(categoria);
    }

    // Read
    public List<Categoria> findAllCategorias() {
        return categoriaRepository.findByAtivoTrue();
    }

    public Categoria findCategoriaById(Long id) {return Services.findObjectById(categoriaRepository, id);}

    // Update
    public Categoria updateCategoria(Long id, DadosAtualizarCategoria dados) {
        var categoria = Services.findObjectById(categoriaRepository, id);

        Updater.update(categoria, dados);

        return categoriaRepository.save(categoria);
    }

    // Delete
    public void deleteLogicoCategoria(Long id) {
        Services.logicDelete(categoriaRepository, id);
    }
}

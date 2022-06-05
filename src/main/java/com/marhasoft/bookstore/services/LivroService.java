package com.marhasoft.bookstore.services;

import com.marhasoft.bookstore.domain.Categoria;
import com.marhasoft.bookstore.domain.Livro;
import com.marhasoft.bookstore.exceptions.ObjectNotFoundException;
import com.marhasoft.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id) {
        Optional<Livro> livro = this.livroRepository.findById(id);
        return livro.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! id "+id+", Tipo: "+Livro.class.getName()));
    }

    public List<Livro> findAll(Integer categoriaId) {
        this.categoriaService.findById(categoriaId);
        return this.livroRepository.findAllByCategoria(categoriaId);
    }

    public Livro update(Integer id, Livro livroRequest) {
        Livro livro = findById(id);
        updateData(livro, livroRequest);
        return this.livroRepository.save(livro);
    }

    private void updateData(Livro livro, Livro livroRequest) {
        livro.setTitulo(livroRequest.getTitulo());
        livro.setNomeAutor(livroRequest.getNomeAutor());
        livro.setTexto(livroRequest.getTexto());
    }

    public Livro create(Integer categoriaId, Livro livroRequest) {
        livroRequest.setId(null);
        Categoria categoria = this.categoriaService.findById(categoriaId);
        livroRequest.setCategoria(categoria);
        return this.livroRepository.save(livroRequest);
    }

    public void delete(Integer id) {
        Livro livro = findById(id);
        this.livroRepository.delete(livro);
    }
}

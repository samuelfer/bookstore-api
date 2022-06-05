package com.marhasoft.bookstore.services;

import com.marhasoft.bookstore.domain.Categoria;
import com.marhasoft.bookstore.dtos.CategoriaDTO;
import com.marhasoft.bookstore.exceptions.DataIntegrityViolationException;
import com.marhasoft.bookstore.exceptions.ObjectNotFoundException;
import com.marhasoft.bookstore.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        Optional<Categoria> categoria = this.categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada! id "+id+", Tipo: "+Categoria.class.getName()));
    }

    public List<Categoria> getAll() {
        return this.categoriaRepository.findAll();
    }

    public Categoria create(Categoria categoria) {
        categoria.setId(null);//Por questao de seguranca, pra nao alterar outro registro
        return this.categoriaRepository.save(categoria);
    }

    public Categoria update(Integer id, CategoriaDTO categoriaDTO) {
        Categoria categoria = findById(id);
        categoria.setNome(categoriaDTO.getNome());
        categoria.setDescricao(categoriaDTO.getDescricao());
        return this.categoriaRepository.save(categoria);
    }

    public void excluir(Integer id) {
        findById(id);
        try {
            this.categoriaRepository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException exception) {
            throw new DataIntegrityViolationException("Categoria não pode ser deletada, ela possui livros associados");
        }
    }
}

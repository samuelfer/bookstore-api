package com.marhasoft.bookstore.services;

import com.marhasoft.bookstore.domain.Categoria;
import com.marhasoft.bookstore.domain.Igreja;
import com.marhasoft.bookstore.domain.Livro;
import com.marhasoft.bookstore.repositories.CategoriaRepository;
import com.marhasoft.bookstore.repositories.IgrejaRepository;
import com.marhasoft.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DbService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private IgrejaRepository igrejaRepository;

    public void instanciaBaseDeDados() {
        Categoria cat1 = new Categoria(null, "Informática", "Livro de TI");

        Igreja igreja = new Igreja(null, "ADCanto de Pedra", "83991941986",
                "adcantodepedra@gmail.com", "Lagoa de Dentro PB");

        Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", cat1);

        cat1.getLivro().addAll(Arrays.asList(l1));

        this.categoriaRepository.saveAll(Arrays.asList(cat1));
        this.livroRepository.saveAll(Arrays.asList(l1));
        this.igrejaRepository.saveAll(Arrays.asList(igreja));
    }
}

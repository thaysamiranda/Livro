package com.ada.livro.bo;

import com.ada.livro.model.Livro;


import java.util.List;
import java.util.Objects;

public interface LivroBusinessObject {

    Livro save(Livro livro);

    List<Livro> findAll();

    void delete(String idLivro);

    Livro getById(String idLivro);

    Livro update(Livro livro);
}

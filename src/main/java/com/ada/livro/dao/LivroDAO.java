package com.ada.livro.dao;

import com.ada.livro.model.Livro;
import java.util.List;
import java.util.Optional;

public interface LivroDAO {

    Livro save(Livro livro);
    List<Livro> findAll();

    void delete(String idLivro);

    Optional<Livro> getById(String id);

    Optional<Livro> update(Livro livro);

}

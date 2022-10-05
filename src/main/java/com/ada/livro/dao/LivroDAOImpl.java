package com.ada.livro.dao;

import com.ada.livro.model.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivroDAOImpl implements LivroDAO{

    private static List<Livro> bancoLivros = new ArrayList<>();

    public List<Livro> findAll() {
        return bancoLivros;
    }

    @Override
    public void delete(String idLivro) {
        bancoLivros.removeIf(livro -> livro.getId().equals(Long.valueOf(idLivro)));
    }

    @Override
    public Optional<Livro> update(Livro dadosNovos) {
        for (Livro livroParaAlterar: bancoLivros) {
            if (livroParaAlterar.getId().equals(dadosNovos.getId())){
                alteraLivro(livroParaAlterar, dadosNovos);
                return Optional.of(livroParaAlterar);
            }
        }
        return Optional.empty();
    }

    private void alteraLivro(Livro livroParaAlterar, Livro dadosNovos) {
        livroParaAlterar.setId(dadosNovos.getId());
        livroParaAlterar.setNome(dadosNovos.getNome());
        livroParaAlterar.setAutor(dadosNovos.getAutor());
    }

    @Override
    public Optional<Livro> getById(String id) {
        for (Livro livroJaCadastrado : bancoLivros){
            if(livroJaCadastrado.getId().equals(Long.valueOf(id))){
                return Optional.of(livroJaCadastrado);
            }
        }
        return Optional.empty();
    }

    public Livro save(Livro livro){
        bancoLivros.add(livro);
        return livro;
    }


}

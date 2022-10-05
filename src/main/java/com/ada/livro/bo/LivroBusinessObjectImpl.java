package com.ada.livro.bo;

import com.ada.livro.dao.LivroDAO;
import com.ada.livro.model.Livro;
import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

public class LivroBusinessObjectImpl implements LivroBusinessObject{


      private LivroDAO livroDAO;


      @Inject
      public LivroBusinessObjectImpl (LivroDAO livroDAO) {
            this.livroDAO = livroDAO;
      }

      public Livro save(Livro livro){
            valida(livro);
            return livroDAO.save(livro);
      }

      public List<Livro> findAll(){
            return livroDAO.findAll();
      }

      @Override
      public void delete(String idLivro) {
            livroDAO.delete(idLivro);
      }

      @Override
      public Livro getById(String id) {
            return livroDAO.getById(id).get();
      }

      @Override
      public Livro update(Livro livro) {
            return livroDAO.update(livro).get();
      }

      private void valida(Livro livro) {
            if(Objects.isNull(livro.getNome())){
                  throw new IllegalArgumentException("Nome inválido. Tente novamente.");
            }
      }
      }

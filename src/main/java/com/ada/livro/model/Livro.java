package com.ada.livro.model;

import lombok.Data;
@Data
public class Livro {

    private Long id;
    private String nome;
    private String autor;

    public Livro(String id, String nome, String autor) {
        this.id = Long.parseLong(id);
        this.nome = nome;
        this.autor = autor;

    }
}

package com.example.VZoo.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Animais {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String nome;
    private String especie;
    private int idade;
    private String avatar;
    private int satisfacao;

    @OneToMany
    private List<Habitats> habitats = new ArrayList<>();

    protected Animais() {}

    public Animais(String nome, String especie) {
        this.nome = nome;
        this.especie = especie;
    }
}

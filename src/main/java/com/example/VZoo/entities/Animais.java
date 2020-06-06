package com.example.VZoo.entities;

import com.example.VZoo.repositories.Satisfacao;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getSatisfacao() {
        return satisfacao;
    }

    public void setSatisfacao(int satisfacao) {
        this.satisfacao = satisfacao;
    }

    public List<Habitats> getHabitats() {
        return habitats;
    }

    public void setHabitats(List<Habitats> habitats) {
        this.habitats = habitats;
    }

    public Habitats getHabitat() {
        return this.habitats.get(this.habitats.size() - 1);
    }

    public void setHabitat(Habitats habitat) {
        this.habitats.add(habitat);
        habitat.addAnimal(this);
    }

    public List<Habitats> getAllHabitats() {
        return this.habitats;
    }

    @Override
    public String toString() {
        return String.format("Animal[id=%d, name='%s', species='%s']", id, nome, especie);
    }

    public void calculateSatisfaction() {
        satisfacao = Satisfacao.calcular(this);
    }


}

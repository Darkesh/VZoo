package com.example.VZoo.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Habitats {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String nome;
    private String avatar;
    private int area;

    @OneToMany
    private List<Animais> animals = new ArrayList<Animais>();

    public Habitats() { }

    public Habitats(String nome, int area) {
        this.nome = nome;
        this.area = area;
    }

    public List<Animais> getAnimais() {
        return animals;
    }

    public void setAnimals(List<Animais> animals) {
        this.animals = animals;
    }

    public void addAnimal(Animais animal) {
        this.animals.add(animal);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

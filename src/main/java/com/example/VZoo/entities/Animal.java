package com.example.VZoo.entities;

import com.example.VZoo.Satisfaction;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String name;
    private String species;
    private int age;
    private String avatar;
    private int satisfaction;

    @OneToMany
    private List<Habitat> habitats = new ArrayList<>();

    protected Animal() {}

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }

    public Habitat getHabitat() {
        return this.habitats.get(this.habitats.size() - 1);
    }

    public void setHabitat(Habitat habitat) {
        this.habitats.add(habitat);
        habitat.addAnimal(this);
    }

    public List<Habitat> getAllHabitats() {
        return this.habitats;
    }

    @Override
    public String toString() {
        return String.format("Animal[id=%d, name='%s', species='%s']", id, name, species);
    }

    public void calculateSatisfaction() {
        satisfaction = Satisfaction.calculate(this);
    }
}

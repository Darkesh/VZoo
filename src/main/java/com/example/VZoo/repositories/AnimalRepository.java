package com.example.VZoo.repositories;

import com.example.VZoo.entities.Animal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
    List<Animal> findBySpecies(String species);
    Animal findById(long id);
    List<Animal> findAll();
}

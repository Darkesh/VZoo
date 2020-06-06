package com.example.VZoo.repositories;

import com.example.VZoo.entities.Habitat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HabitatRepository extends CrudRepository<Habitat, Long> {
    Habitat findById(long id);
    List<Habitat> findAll();
}

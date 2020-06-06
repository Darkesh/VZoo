package com.example.VZoo.repositories;

import java.util.List;
import com.example.VZoo.entities.Animais;
import org.springframework.data.repository.CrudRepository;

public interface AnimaisRepository extends CrudRepository<Animais, Long>  {
    List<Animais> findByEspecie(String species);
    Animais findById(long id);
    List<Animais> findAll();
}

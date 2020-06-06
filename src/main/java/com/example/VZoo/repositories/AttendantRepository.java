package com.example.VZoo.repositories;

import com.example.VZoo.entities.Attendant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// Create
// Read
// Update
// Delete

public interface AttendantRepository extends CrudRepository<Attendant, Long> {
    public List<Attendant> findByEmail(String email);
}

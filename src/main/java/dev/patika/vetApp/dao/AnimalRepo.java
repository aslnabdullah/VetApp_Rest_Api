package dev.patika.vetApp.dao;

import dev.patika.vetApp.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepo extends JpaRepository<Animal,Long> {
    Animal findByName(String name);

    List<Animal> findByCustomerId(Long customer_id);
}

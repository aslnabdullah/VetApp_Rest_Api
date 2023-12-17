package dev.patika.vetApp.business.abs;

import dev.patika.vetApp.entity.Animal;


import java.util.List;

public interface IAnimalService {

    Animal getByID(Long id);
    Animal save(Animal animal);
    String delete(Long id);
    Animal update(Animal animal);
    List<Animal> findAll();

    Animal getByName(String name);

    List<Animal> findByCustomerId(Long customer_id);
}

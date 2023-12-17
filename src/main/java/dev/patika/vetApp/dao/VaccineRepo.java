package dev.patika.vetApp.dao;

import dev.patika.vetApp.entity.Animal;
import dev.patika.vetApp.entity.Customer;
import dev.patika.vetApp.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VaccineRepo extends JpaRepository<Vaccine,Long> {

    Vaccine findByName(String name);

    Vaccine findByAnimalIdAndName(Long animal_id, String name);

    List<Vaccine> findAllByProtectionStartDateBetween(LocalDate startDate, LocalDate finishDate);

    List<Vaccine> findByAnimalId(Long id);


}

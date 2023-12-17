package dev.patika.vetApp.business.abs;

import dev.patika.vetApp.entity.Customer;
import dev.patika.vetApp.entity.Vaccine;

import java.time.LocalDate;
import java.util.List;

public interface IVaccineService {

    Vaccine getByID(Long id);
    Vaccine save(Vaccine vaccine);
    String delete(Long id);
    Vaccine update(Vaccine vaccine);
    List<Vaccine> findAll();
    Vaccine getByName(String name);

    List<Vaccine> findAllByProtectionStartDateBetween(LocalDate startDate, LocalDate finishDate);

    List<Vaccine> findByAnimalId(Long id);


}

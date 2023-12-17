package dev.patika.vetApp.business.concrete;

import dev.patika.vetApp.business.abs.IVaccineService;
import dev.patika.vetApp.dao.VaccineRepo;
import dev.patika.vetApp.entity.Vaccine;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class VaccineManager  implements IVaccineService {

    private final VaccineRepo vaccineRepo;

    public VaccineManager(VaccineRepo vaccineRepo) {
        this.vaccineRepo = vaccineRepo;
    }


    @Override
    public Vaccine getByID(Long id) {
        return this.vaccineRepo.findById(id).orElseThrow();
    }

    @Override
    public Vaccine save(Vaccine vaccine) {
        Long animal_id = vaccine.getAnimal().getId();
        String name = vaccine.getName();
        Vaccine animalLastVaccine = vaccineRepo.findByAnimalIdAndName(animal_id,name);
        if (animalLastVaccine == null ){
            return this.vaccineRepo.save(vaccine);
        }
        else {
            if (animalLastVaccine.getProtectionFinishDate().isBefore(vaccine.getProtectionStartDate())){
                return this.vaccineRepo.save(vaccine);
            }
            else {
                throw new ResponseStatusException(HttpStatus.CONFLICT);
            }
        }
    }

    @Override
    public String delete(Long id) {
        this.vaccineRepo.delete(this.getByID(id));
        return "vaccine deleted with this id : " + id;
    }

    @Override
    public Vaccine update(Vaccine vaccine) {
        Vaccine existVaccine = vaccineRepo.findById(vaccine.getId()).orElseThrow();

        existVaccine.setName(vaccine.getName());
        existVaccine.setCode(vaccine.getCode());
        existVaccine.setProtectionStartDate(vaccine.getProtectionStartDate());
        existVaccine.setProtectionFinishDate(vaccine.getProtectionFinishDate());
        return this.vaccineRepo.save(existVaccine);
    }

    @Override
    public List<Vaccine> findAll() {
        return this.vaccineRepo.findAll();
    }

    @Override
    public Vaccine getByName(String name) {
        return this.vaccineRepo.findByName(name);
    }

    @Override
    public List<Vaccine> findAllByProtectionStartDateBetween(LocalDate startDate, LocalDate finishDate) {
        return this.vaccineRepo.findAllByProtectionStartDateBetween(startDate,finishDate);
    }

    @Override
    public List<Vaccine> findByAnimalId(Long id) {
        return this.vaccineRepo.findByAnimalId(id);
    }

}

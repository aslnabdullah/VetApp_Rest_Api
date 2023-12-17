package dev.patika.vetApp.api;

import dev.patika.vetApp.business.abs.IVaccineService;
import dev.patika.vetApp.entity.Appointment;
import dev.patika.vetApp.entity.Customer;
import dev.patika.vetApp.entity.Vaccine;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/vaccines")
public class VaccineController {

    private final IVaccineService vaccineService;

    public VaccineController(IVaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Vaccine> findAll(){
        return this.vaccineService.findAll();
    }

    @GetMapping("/getByID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Vaccine getByID(@PathVariable("id") Long id){
        return this.vaccineService.getByID(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Vaccine addVaccine(@RequestBody Vaccine vaccine){
        return this.vaccineService.save(vaccine);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Vaccine updateVaccine(@RequestBody Vaccine vaccine){
        return this.vaccineService.update(vaccine);
    }

    @DeleteMapping("/deleteByID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteByID(@PathVariable("id") Long id){
        return this.vaccineService.delete(id);
    }

    @GetMapping("/getBetween")//http://localhost:5656/vaccine/getBetween?startDate=2023-01-01&endDate=2024-01-01
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Vaccine>> getAnimalVaccinesBetween(
            @RequestParam @DateTimeFormat (iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat (iso = DateTimeFormat.ISO.DATE) LocalDate endDate){
        List<Vaccine> vaccines = vaccineService.findAllByProtectionStartDateBetween(startDate,endDate);
        if (vaccines.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(vaccines);

    }

    @GetMapping("/getByAnimalId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Vaccine> getByAnimalId(@PathVariable("id") Long id){
        return this.vaccineService.findByAnimalId(id);
    }



}

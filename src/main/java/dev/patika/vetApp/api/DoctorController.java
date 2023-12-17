package dev.patika.vetApp.api;


import dev.patika.vetApp.business.abs.IDoctorService;
import dev.patika.vetApp.entity.Customer;
import dev.patika.vetApp.entity.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final IDoctorService doctorService;

    public DoctorController(IDoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> findAll(){
        return this.doctorService.findAll();
    }

    @GetMapping("/getByID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor getByID(@PathVariable("id") Long id){
        return this.doctorService.getByID(id);
    }

    @GetMapping("/getByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor getByName(@PathVariable("name") String name){
        return this.doctorService.getByName(name);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor addDoctor(@RequestBody Doctor doctor){
        return this.doctorService.save(doctor);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Doctor updateDoctor(@RequestBody Doctor doctor){
        return this.doctorService.update(doctor);
    }

    @DeleteMapping("/deleteByID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteByID(@PathVariable("id") Long id){
        return this.doctorService.delete(id);
    }
}

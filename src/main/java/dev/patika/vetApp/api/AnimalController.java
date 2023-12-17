package dev.patika.vetApp.api;

import dev.patika.vetApp.business.abs.IAnimalService;
import dev.patika.vetApp.entity.Animal;
import dev.patika.vetApp.entity.Customer;
import dev.patika.vetApp.entity.Doctor;
import dev.patika.vetApp.entity.Vaccine;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final IAnimalService animalService;

    public AnimalController(IAnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> findAll(){
        return this.animalService.findAll();
    }

    @GetMapping("/getByID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Animal getByID(@PathVariable("id") Long id){
        return this.animalService.getByID(id);
    }

    @GetMapping("/getByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Animal getByName(@PathVariable("name") String name){
        return this.animalService.getByName(name);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Animal addAnimal(@RequestBody Animal animal){
        return this.animalService.save(animal);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Animal updateAnimal(@RequestBody Animal animal){
        return this.animalService.update(animal);
    }

    @DeleteMapping("/deleteByID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteByID(@PathVariable("id") Long id){
        return this.animalService.delete(id);
    }

    @GetMapping("/getByCustomerId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> getByAnimalId(@PathVariable("id") Long id){
        return this.animalService.findByCustomerId(id);
    }
}

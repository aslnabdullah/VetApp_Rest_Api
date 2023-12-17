package dev.patika.vetApp.api;

import dev.patika.vetApp.business.abs.IAvailableDateService;
import dev.patika.vetApp.entity.AvailableDate;
import dev.patika.vetApp.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/availableDate")
public class AvailableDateController {

    private final IAvailableDateService availableDateService;

    public AvailableDateController(IAvailableDateService availableDateService) {
        this.availableDateService = availableDateService;
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<AvailableDate> findAll(){
        return this.availableDateService.findAll();
    }

    @GetMapping("/getByID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AvailableDate getByID(@PathVariable("id") Long id){
        return this.availableDateService.getByID(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AvailableDate addAvailableDate(@RequestBody AvailableDate availableDate){
        return this.availableDateService.save(availableDate);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public AvailableDate updateAvailableDate(@RequestBody AvailableDate availableDate){
        return this.availableDateService.update(availableDate);
    }

    @DeleteMapping("/deleteByID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteByID(@PathVariable("id") Long id){
        return this.availableDateService.delete(id);
    }
}

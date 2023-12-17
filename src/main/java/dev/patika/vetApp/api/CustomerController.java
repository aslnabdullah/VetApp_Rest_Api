package dev.patika.vetApp.api;

import dev.patika.vetApp.business.abs.ICustomerService;
import dev.patika.vetApp.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findAll(){
        return this.customerService.findAll();
    }

    @GetMapping("/getByID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getByID(@PathVariable("id") Long id){
        return this.customerService.getByID(id);
    }

    @GetMapping("/getByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getByName(@PathVariable("name") String name){
        return this.customerService.getByName(name);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer){
        return this.customerService.save(customer);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Customer updateCustomer(@RequestBody Customer customer){
        return this.customerService.update(customer);
    }

    @DeleteMapping("/deleteByID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteByID(@PathVariable("id") Long id){
        return this.customerService.delete(id);
    }


}

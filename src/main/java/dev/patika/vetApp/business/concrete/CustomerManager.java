package dev.patika.vetApp.business.concrete;

import dev.patika.vetApp.business.abs.ICustomerService;
import dev.patika.vetApp.dao.CustomerRepo;
import dev.patika.vetApp.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements ICustomerService {
    private final CustomerRepo customerRepo;

    public CustomerManager(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer getByID(Long id) {
        return this.customerRepo.findById(id).orElseThrow();
    }

    @Override
    public Customer save(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public String delete(Long id) {
        this.customerRepo.delete(this.getByID(id));
        return "customer deleted with this id : " + id;
    }

    @Override
    public Customer update(Customer customer) {
        Customer existCustomer = customerRepo.findById(customer.getId()).orElseThrow();
        existCustomer.setAdress(customer.getAdress());
        existCustomer.setCity(customer.getCity());
        existCustomer.setName(customer.getName());
        existCustomer.setMail(customer.getMail());
        existCustomer.setPhone(customer.getPhone());
        return this.customerRepo.save(existCustomer);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepo.findAll();
    }

    @Override
    public Customer getByName(String name) {
        return this.customerRepo.findByName(name);
    }
}

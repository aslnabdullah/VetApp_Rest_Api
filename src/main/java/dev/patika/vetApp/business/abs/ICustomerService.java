package dev.patika.vetApp.business.abs;

import dev.patika.vetApp.entity.Customer;

import java.util.List;

public interface ICustomerService {
    Customer getByID(Long id);
    Customer save(Customer customer);
    String delete(Long id);
    Customer update(Customer customer);
    List<Customer> findAll();
    Customer getByName(String name);
}

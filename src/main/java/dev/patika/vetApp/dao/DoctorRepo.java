package dev.patika.vetApp.dao;

import dev.patika.vetApp.entity.AvailableDate;
import dev.patika.vetApp.entity.Customer;
import dev.patika.vetApp.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Long> {
    Doctor findByName(String name);
}

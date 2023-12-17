package dev.patika.vetApp.business.abs;

import dev.patika.vetApp.entity.Doctor;

import java.util.List;

public interface IDoctorService {

    Doctor getByID(Long id);
    Doctor save(Doctor doctor);
    String delete(Long id);
    Doctor update(Doctor doctor);
    List<Doctor> findAll();

    Doctor getByName(String name);
}

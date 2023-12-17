package dev.patika.vetApp.dao;

import dev.patika.vetApp.entity.AvailableDate;
import dev.patika.vetApp.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AvailableDateRepo extends JpaRepository<AvailableDate,Long> {
    List<AvailableDate> findByAvailableDateAndDoctorId(LocalDate availableDate,Long doctorId);
}

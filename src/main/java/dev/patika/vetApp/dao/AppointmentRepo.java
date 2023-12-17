package dev.patika.vetApp.dao;

import dev.patika.vetApp.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long> {

    Appointment findByAppointmentDateAndDoctorId(LocalDateTime appointmentTime,Long doctorId);

    List<Appointment> findByAppointmentDateBetweenAndAnimalId(LocalDateTime startDate,LocalDateTime endDate,Long animal_id);
    List<Appointment> findByAppointmentDateBetweenAndDoctorId(LocalDateTime startDate,LocalDateTime endDate,Long doctor_id);


}

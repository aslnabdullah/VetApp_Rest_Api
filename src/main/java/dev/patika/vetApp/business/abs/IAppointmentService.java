package dev.patika.vetApp.business.abs;

import dev.patika.vetApp.entity.Appointment;
import dev.patika.vetApp.entity.Customer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IAppointmentService {

    Appointment getByID(Long id);
    Appointment save(Appointment appointment);
    String delete(Long id);
    Appointment update(Appointment appointment);
    List<Appointment> findAll();

    List<Appointment> findByAnimalIdBetweenDates(LocalDateTime startDate, LocalDateTime endDate, Long animal_id);

    List<Appointment> findByDoctorIdBetweenDates(LocalDateTime startDate,LocalDateTime endDate,Long doctor_id);



}

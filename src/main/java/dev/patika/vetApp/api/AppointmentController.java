package dev.patika.vetApp.api;


import dev.patika.vetApp.business.abs.IAppointmentService;
import dev.patika.vetApp.entity.Appointment;
import dev.patika.vetApp.entity.Customer;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final IAppointmentService appointmentService;

    public AppointmentController(IAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> findAll(){
        return this.appointmentService.findAll();
    }

    @GetMapping("/getByID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment getByID(@PathVariable("id") Long id){
        return this.appointmentService.getByID(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment addAppointment(@RequestBody Appointment appointment){
        return this.appointmentService.save(appointment);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Appointment updateAppointment(@RequestBody Appointment appointment){
        return this.appointmentService.update(appointment);
    }

    @DeleteMapping("/deleteByID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteByID(@PathVariable("id") Long id){
        return this.appointmentService.delete(id);
    }

    @GetMapping("/getByAnimalIdBetween")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> listApoByAnimalIdBetween(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate endDate,
            @RequestParam("animalId") long id){

        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(23,59,59);
        return appointmentService.findByAnimalIdBetweenDates(startDateTime,endDateTime,id);
    }

    @GetMapping("/getByDoctorIdBetween")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> listApoByDoctorIdBetween(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate endDate,
            @RequestParam("doctorId") long id){
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(23,59,59);
        return appointmentService.findByDoctorIdBetweenDates(startDateTime,endDateTime,id);
    }

}

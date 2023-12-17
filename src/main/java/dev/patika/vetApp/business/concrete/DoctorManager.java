package dev.patika.vetApp.business.concrete;

import dev.patika.vetApp.business.abs.IDoctorService;
import dev.patika.vetApp.dao.DoctorRepo;
import dev.patika.vetApp.entity.Doctor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorManager implements IDoctorService {

    private final DoctorRepo doctorRepo;

    public DoctorManager(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public Doctor getByID(Long id) {
        return this.doctorRepo.findById(id).orElseThrow();
    }

    @Override
    public Doctor save(Doctor doctor) {
        return this.doctorRepo.save(doctor);
    }

    @Override
    public String delete(Long id) {
        this.doctorRepo.delete(this.getByID(id));
        return "doctor deleted with this id : " + id;
    }

    @Override
    public Doctor update(Doctor doctor) {
        Doctor existDoctor = doctorRepo.findById(doctor.getId()).orElseThrow();
        existDoctor.setName(doctor.getName());
        existDoctor.setPhone(doctor.getPhone());
        existDoctor.setMail(doctor.getMail());
        existDoctor.setAddress(doctor.getAddress());
        existDoctor.setCity(doctor.getCity());
        return this.doctorRepo.save(existDoctor);
    }

    @Override
    public List<Doctor> findAll() {
        return this.doctorRepo.findAll();
    }

    @Override
    public Doctor getByName(String name) {
        return this.doctorRepo.findByName(name);
    }

}

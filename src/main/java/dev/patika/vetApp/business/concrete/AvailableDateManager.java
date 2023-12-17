package dev.patika.vetApp.business.concrete;

import dev.patika.vetApp.business.abs.IAvailableDateService;
import dev.patika.vetApp.dao.AvailableDateRepo;
import dev.patika.vetApp.entity.AvailableDate;
import dev.patika.vetApp.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableDateManager implements IAvailableDateService {

    private final AvailableDateRepo availableDateRepo;

    public AvailableDateManager(AvailableDateRepo availableDateRepo) {
        this.availableDateRepo = availableDateRepo;
    }

    @Override
    public AvailableDate getByID(Long id) {
        return this.availableDateRepo.findById(id).orElseThrow();
    }

    @Override
    public AvailableDate save(AvailableDate availableDate) {
        return this.availableDateRepo.save(availableDate);
    }

    @Override
    public String delete(Long id) {
        this.availableDateRepo.delete(this.getByID(id));
        return "available date deleted with this id : " + id;
    }

    @Override
    public AvailableDate update(AvailableDate availableDate) {
        AvailableDate existAvailableDate = availableDateRepo.findById(availableDate.getId()).orElseThrow();
        existAvailableDate.setAvailableDate(availableDate.getAvailableDate());
        return this.availableDateRepo.save(existAvailableDate);
    }

    @Override
    public List<AvailableDate> findAll() {
        return this.availableDateRepo.findAll();
    }

}

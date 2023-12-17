package dev.patika.vetApp.business.abs;

import dev.patika.vetApp.entity.AvailableDate;

import java.util.List;

public interface IAvailableDateService {

    AvailableDate getByID(Long id);
    AvailableDate save(AvailableDate availableDate);
    String delete(Long id);
    AvailableDate update(AvailableDate availableDate);
    List<AvailableDate> findAll();

}

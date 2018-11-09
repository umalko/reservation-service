package com.mavs.reservationservice.service;


import com.mavs.reservationservice.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    List<Reservation> getAll();

    Optional<Reservation> getById(Integer id);

    Reservation save(Reservation reservation);

    void update(Reservation reservation);

    void deleteById(Integer id);

}

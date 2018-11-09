package com.mavs.reservationservice.service.impl;

import com.google.common.collect.Lists;
import com.mavs.reservationservice.model.Reservation;
import com.mavs.reservationservice.repository.ReservationRepository;
import com.mavs.reservationservice.service.ReservationService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> getAll() {
        return Lists.newArrayList(reservationRepository.findAll());
    }

    @Override
    public Optional<Reservation> getById(Integer id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void update(Reservation reservation) {
        reservationRepository.findById(reservation.getId()).ifPresent(dbReservation -> {
            BeanUtils.copyProperties(reservation, dbReservation);
            reservationRepository.save(dbReservation);
        });
    }

    @Override
    public void deleteById(Integer id) {
        reservationRepository.deleteById(id);
    }
}

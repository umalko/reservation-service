package com.mavs.reservationservice.controller;

import com.mavs.reservationservice.client.UserClient;
import com.mavs.reservationservice.client.dto.UserDto;
import com.mavs.reservationservice.model.Reservation;
import com.mavs.reservationservice.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    private final UserClient userClient;

    @Autowired
    public ReservationController(ReservationService reservationService, UserClient userClient) {
        this.reservationService = reservationService;
        this.userClient = userClient;
    }

    @GetMapping("/user/{id}")
    public UserDto getUSer(@PathVariable Integer id) {
        return userClient.findUserById(id);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Reservation getById(@Value("id") Integer id) {
        return reservationService.getById(id).get();
    }

    @PostMapping
    public void save(@RequestBody Reservation reservation) {
        reservationService.save(reservation);
    }

    @PutMapping
    public void update(@RequestBody Reservation reservation) {
        reservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@Value("id") Integer id) {
        reservationService.deleteById(id);
    }
}

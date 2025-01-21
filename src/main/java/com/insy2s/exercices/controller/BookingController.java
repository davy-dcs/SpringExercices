package com.insy2s.exercices.controller;

import com.insy2s.exercices.domain.Booking;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private ArrayList<Booking> bookings = new ArrayList<>();

    @GetMapping
    public ResponseEntity<ArrayList<Booking>> get() {
        return ResponseEntity.status(HttpStatus.OK).body(bookings);
    }

    @PostMapping
    public ResponseEntity<String> post(@RequestBody Booking booking) {
        return bookings.add(booking) ?
                ResponseEntity.status(HttpStatus.CREATED).body("Réservation confirmée avec l'id " + booking.getId()) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> put(@PathVariable int id, @RequestBody Booking booking) {
        for (Booking b : bookings) {
            if (b.getId() == id) {
                if (booking.getRoom() != null) {
                    b.setRoom(b.getRoom());
                }
                if (booking.getDate() != null) {
                    b.setDate(b.getDate());
                }
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        return bookings.removeIf(booking -> booking.getId() == id) ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

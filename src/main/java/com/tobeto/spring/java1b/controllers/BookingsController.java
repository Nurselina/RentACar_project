package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.entities.Booking;
import com.tobeto.spring.java1b.repositories.BookingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bookings")
public class BookingsController {
    private final BookingRepository bookingRepository;

    public BookingsController(BookingRepository bookingRepository){
        this.bookingRepository =bookingRepository;
    }

    @GetMapping
    public List<Booking> getAll(){
        return bookingRepository.findAll();
    }

    @GetMapping("{id}")
    public Booking getById(@PathVariable int id){
        return bookingRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Booking booking){
        bookingRepository.save(booking);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody Booking booking){
        bookingRepository.findById(booking.getId()).orElseThrow();
        bookingRepository.save(booking);

    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        bookingRepository.deleteById(id);

    }

}

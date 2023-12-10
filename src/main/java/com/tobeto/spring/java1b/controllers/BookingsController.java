package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.entities.Booking;
import com.tobeto.spring.java1b.repositories.BookingRepository;
import com.tobeto.spring.java1b.services.abstracts.BookingService;
import com.tobeto.spring.java1b.services.dtos.requests.booking.AddBookingRequest;
import com.tobeto.spring.java1b.services.dtos.requests.booking.UpdateBookingRequest;
import com.tobeto.spring.java1b.services.dtos.responses.booking.GetBookingListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.booking.GetBookingResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/bookings")
@AllArgsConstructor
public class BookingsController {
    private final BookingService bookingService;


    @GetMapping
    public List<GetBookingListResponse> getAll(){
       return bookingService.getAll();
    }

    @GetMapping("{id}")
    public GetBookingResponse getById(@PathVariable int id){
       return bookingService.getById(id);
    }
    @PostMapping
    public void add(@RequestBody AddBookingRequest addBookingRequest){
       bookingService.add(addBookingRequest);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateBookingRequest updateBookingRequest) throws Exception {
       bookingService.update(id,updateBookingRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
       bookingService.delete(id);

    }
    @GetMapping("betweenDate")
    public List<GetBookingListResponse> betweenDate(@RequestParam LocalDate date1,LocalDate date2){
        return bookingService.betweenDate(date1, date2);
    }

    @GetMapping("startDateAfter")
    public List<GetBookingListResponse> startDateAfter(@RequestParam LocalDate date ){
        return bookingService.startDateAfter(date);
    }

    @GetMapping("findByEndDate")
    public List<GetBookingListResponse> findByEndDate(@RequestParam LocalDate endDate){
        return bookingService.findByEndDate(endDate);
    }

   @GetMapping("endDateOrStartDate")
    public List<GetBookingListResponse> endDateOrStartDate (@RequestParam LocalDate startDate,LocalDate endDate){
        return bookingService.findByEndDateOrStartDate(startDate,endDate);
    }

}

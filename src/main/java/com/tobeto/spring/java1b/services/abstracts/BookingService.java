package com.tobeto.spring.java1b.services.abstracts;

import com.tobeto.spring.java1b.services.dtos.requests.booking.AddBookingRequest;
import com.tobeto.spring.java1b.services.dtos.requests.booking.UpdateBookingRequest;
import com.tobeto.spring.java1b.services.dtos.responses.booking.GetBookingListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.booking.GetBookingResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    List<GetBookingListResponse> getAll();
    GetBookingResponse getById(int id);
    void add(AddBookingRequest addBookingRequest);
    void update(int id, UpdateBookingRequest updateBookingRequest) throws Exception;
    void delete(int id);
    List<GetBookingListResponse> betweenDate (LocalDate date1,LocalDate date2);
    List<GetBookingListResponse> startDateAfter (LocalDate date);
    List<GetBookingListResponse> findByEndDate (LocalDate endDate);
    List<GetBookingListResponse> findByEndDateOrStartDate (LocalDate startDate,LocalDate endDate);



}

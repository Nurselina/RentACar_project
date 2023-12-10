package com.tobeto.spring.java1b.services.concretes;

import com.tobeto.spring.java1b.entities.Booking;
import com.tobeto.spring.java1b.repositories.BookingRepository;
import com.tobeto.spring.java1b.services.abstracts.BookingService;
import com.tobeto.spring.java1b.services.dtos.requests.booking.AddBookingRequest;
import com.tobeto.spring.java1b.services.dtos.requests.booking.UpdateBookingRequest;
import com.tobeto.spring.java1b.services.dtos.responses.booking.GetBookingListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.booking.GetBookingResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingManager implements BookingService {
    private final BookingRepository bookingRepository;
    @Override
    public List<GetBookingListResponse> getAll() {
        List<Booking> bookingList= bookingRepository.findAll();
        List<GetBookingListResponse> getBookingListResponses=new ArrayList<>();
        for (Booking booking:bookingList){
            GetBookingListResponse response=new GetBookingListResponse();
            response.setStartDate(booking.getStartDate());
            response.setEndDate(booking.getEndDate());
            getBookingListResponses.add(response);
        }

        return getBookingListResponses;
    }

    @Override
    public GetBookingResponse getById(int id) {
        Booking booking=bookingRepository.findById(id).orElseThrow();
        GetBookingResponse getBookingResponse=new GetBookingResponse();
        getBookingResponse.setStartDate(booking.getStartDate());
        getBookingResponse.setEndDate(booking.getEndDate());

        return getBookingResponse;
    }

    @Override
    public void add(AddBookingRequest addBookingRequest) {
        Booking booking=new Booking();
        booking.setStartDate(addBookingRequest.getStartDate());
        booking.setEndDate(addBookingRequest.getEndDate());
        bookingRepository.save(booking);
    }

    @Override
    public void update(int id, UpdateBookingRequest updateBookingRequest) throws Exception {
        Optional<Booking> optionalBooking=bookingRepository.findById(id);

        if (optionalBooking.isPresent()){
            Booking booking=optionalBooking.get();
            booking.setStartDate(updateBookingRequest.getStartDate());
            booking.setEndDate(updateBookingRequest.getEndDate());
            bookingRepository.save(booking);
        }else {
            throw new Exception("Güncellenemedi.");
        }

    }

    @Override
    public void delete(int id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public List<GetBookingListResponse> betweenDate(LocalDate date1, LocalDate date2) {
        List<Booking> bookingList=bookingRepository.findByStartDateBetween(date1, date2);
        List<GetBookingListResponse> getBookingListResponses=new ArrayList<>();
        for (Booking booking: bookingList){
            GetBookingListResponse response= new GetBookingListResponse();
            response.setStartDate(booking.getStartDate());
            response.setEndDate(booking.getEndDate());
            getBookingListResponses.add(response);
        }
        return getBookingListResponses;
    }

    @Override
    public List<GetBookingListResponse> startDateAfter(LocalDate date) {
        List<Booking> bookingList =bookingRepository.findByStartDateAfter(date);
        List<GetBookingListResponse> getBookingListResponses= new ArrayList<>();
        for (Booking booking : bookingList){
            GetBookingListResponse response = new GetBookingListResponse();
            response.setStartDate(booking.getStartDate());
            response.setEndDate(booking.getEndDate());
            getBookingListResponses.add(response);
        }
        return getBookingListResponses;
    }

    @Override
    public List<GetBookingListResponse> findByEndDate(LocalDate endDate) {
        return bookingRepository.findByEndDate(endDate);
    }

    @Override
    public List<GetBookingListResponse> findByEndDateOrStartDate(LocalDate startDate,LocalDate endDate) {
        return bookingRepository.findByEndDateOrStartDate(startDate, endDate);
    }


}

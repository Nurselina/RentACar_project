package com.tobeto.spring.java1b.repositories;

import com.tobeto.spring.java1b.entities.Booking;
import com.tobeto.spring.java1b.services.dtos.responses.booking.GetBookingListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    //Derived Query Methods
    List<Booking>  findByStartDateBetween(LocalDate date1,LocalDate date2);
    List<Booking> findByStartDateAfter (LocalDate date);

    //JPQL Query Methods
    @Query("select new com.tobeto.spring.java1b.services.dtos.responses.booking.GetBookingListResponse(b.startDate, b.endDate)" +
            " from Booking b WHERE b.endDate = :endDate")
    List<GetBookingListResponse> findByEndDate (LocalDate endDate);

    @Query("select new com.tobeto.spring.java1b.services.dtos.responses.booking.GetBookingListResponse(b.startDate, b.endDate)" +
            " from Booking b where b.endDate IS NULL")
    List<GetBookingListResponse> findByEndDateIsNull ();
}

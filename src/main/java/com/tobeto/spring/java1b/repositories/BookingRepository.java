package com.tobeto.spring.java1b.repositories;

import com.tobeto.spring.java1b.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}

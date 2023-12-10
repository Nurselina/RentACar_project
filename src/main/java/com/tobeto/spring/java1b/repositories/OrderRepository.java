package com.tobeto.spring.java1b.repositories;

import com.tobeto.spring.java1b.entities.Order;
import com.tobeto.spring.java1b.services.dtos.responses.order.GetOrderListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    //Derived Query Methods
    List<Order> findByAmountLessThanEqual (double amount);

    //JPQL Query Methods

    @Query("select new com.tobeto.spring.java1b.services.dtos.responses.order.GetOrderListResponse" +
            "(o.amount, o.date, o.starRent, o.endRent) " +
            "from Order o where o.startDate between :date1 AND :date2")
    List<GetOrderListResponse> findByStartDateBetween(LocalDate date1, LocalDate date2);


}

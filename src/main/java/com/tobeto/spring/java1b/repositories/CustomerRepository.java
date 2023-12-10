package com.tobeto.spring.java1b.repositories;

import com.tobeto.spring.java1b.entities.Customer;
import com.tobeto.spring.java1b.services.dtos.responses.customer.GetCustomerListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
   //Derived Query Methods
   List<Customer> findByEmailIsNull();
   List<Customer> findByFirstNameIgnoreCase (String name);

   //JPQL Query Methods
   @Query("select new com.tobeto.spring.java1b.services.dtos.responses.customer.GetCustomerListResponse" +
           "(c.firstName, c.lastName, c.phone) " +
           "from Customer c where c.firstName LIKE %:firstName% AND c.lastName LIKE %:lastName%")
   List<GetCustomerListResponse> findByFirstNameAndLastNameIsContaining (String firstName, String lastName);

   @Query("SELECT new com.tobeto.spring.java1b.services.dtos.responses.customer.GetCustomerListResponse" +
           "(c.firstName, c.lastName, c.phone) " +
           "FROM Customer c WHERE c.firstName = :firstName AND c.lastName IS NULL")
   List<GetCustomerListResponse> findByFirstNameAndLastNameIsNull(String firstName);


}

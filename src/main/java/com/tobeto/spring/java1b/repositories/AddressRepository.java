package com.tobeto.spring.java1b.repositories;

import com.tobeto.spring.java1b.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {

}

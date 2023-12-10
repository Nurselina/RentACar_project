package com.tobeto.spring.java1b.repositories;

import com.tobeto.spring.java1b.entities.Address;
import com.tobeto.spring.java1b.services.dtos.responses.address.GetAddressListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    //Derived Query Methods
    List<Address> findByPostalCodeOrAddressText(String postalCode, String text);
    Address findByAddressTextIgnoreCase(String text);

    //JPQL Query Methods
   @Query("SELECT new com.tobeto.spring.java1b.services.dtos.responses.address.GetAddressListResponse" +
            "(a.postalCode,a.addressText, new com.tobeto.spring.java1b.services.dtos.responses.city.GetCityListResponse(c.name)) " +
            "from Address a INNER JOIN a.city c WHERE a.addressText = :addressText")
      List<GetAddressListResponse> findByAddressText (String addressText);

    @Query("SELECT new com.tobeto.spring.java1b.services.dtos.responses.address.GetAddressListResponse" +
            "(a.postalCode,a.addressText, new com.tobeto.spring.java1b.services.dtos.responses.city.GetCityListResponse(c.name))" +
            " FROM Address a INNER JOIN a.city c WHERE a.postalCode = :postalCode AND a.addressText = :addressText")
    List<GetAddressListResponse>findByPostalCodeAndAddressText( String postalCode,String addressText);

    boolean existsByPostalCode(String postalCode);
}

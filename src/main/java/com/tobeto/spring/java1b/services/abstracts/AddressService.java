package com.tobeto.spring.java1b.services.abstracts;


import com.tobeto.spring.java1b.services.dtos.requests.address.AddAddressRequest;
import com.tobeto.spring.java1b.services.dtos.requests.address.UpdateAddressRequest;
import com.tobeto.spring.java1b.services.dtos.responses.address.GetAddressListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.address.GetAddressResponse;

import java.util.List;

public interface AddressService {
    void add(AddAddressRequest request);
    List<GetAddressListResponse> getAll();
    GetAddressResponse getById(int id);
    void update(int id, UpdateAddressRequest updateAddressRequest) throws Exception;
    void delete(int id);
    List<GetAddressListResponse> textPostaCode(String postalCode, String text);
    GetAddressResponse text (String text);
    List<GetAddressListResponse> findByAddressText(String addressText);
    List<GetAddressListResponse> postalCodeAndAddressText (String postalCode,String addressText);


}

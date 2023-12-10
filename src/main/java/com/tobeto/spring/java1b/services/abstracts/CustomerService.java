package com.tobeto.spring.java1b.services.abstracts;

import com.tobeto.spring.java1b.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.java1b.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.java1b.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.customer.GetCustomerResponse;


import java.util.List;

public interface CustomerService {
    List<GetCustomerListResponse> getAll();
    GetCustomerResponse getById(int id);
    void add(AddCustomerRequest customerAdd);
    void update(int id, UpdateCustomerRequest updateCustomerRequest) throws Exception;
    void delete(int id);
    List<GetCustomerListResponse> isNull ();
    List<GetCustomerListResponse> ignoreName(String name);
    List<GetCustomerListResponse> firstNameAndLastNameLike (String firstName, String lastName);
    List<GetCustomerListResponse> findByFirstNameAndLastNameIsNull(String firstName);
}

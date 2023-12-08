package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.services.abstracts.CustomerService;
import com.tobeto.spring.java1b.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.java1b.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.java1b.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.customer.GetCustomerResponse;
import com.tobeto.spring.java1b.entities.Customer;
import com.tobeto.spring.java1b.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
public class CustomersController {
    private final CustomerService customerService;

    @GetMapping
    public List<GetCustomerListResponse> getAll(){
       return customerService.getAll();
    }

    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id){

      return customerService.getById(id);
    }
    @PostMapping
    public void add(@RequestBody AddCustomerRequest customerAdd){
       customerService.add(customerAdd);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCustomerRequest updateCustomerRequest) throws Exception {
       customerService.update(id,updateCustomerRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        customerService.delete(id);

    }
    @GetMapping("isNull")
    public List<GetCustomerListResponse> isNull (){
        return customerService.isNull();
    }

    @GetMapping("ignoreName")
    public List<GetCustomerListResponse> ignoreName(String name){
        return customerService.ignoreName(name);
    }
}

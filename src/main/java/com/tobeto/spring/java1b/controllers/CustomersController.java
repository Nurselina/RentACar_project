package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.java1b.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.java1b.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.java1b.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring.java1b.dtos.responses.customer.GetCustomerResponse;
import com.tobeto.spring.java1b.entities.Car;
import com.tobeto.spring.java1b.entities.Customer;
import com.tobeto.spring.java1b.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/customers")
public class CustomersController {
    private final CustomerRepository customerRepository;

    public CustomersController(CustomerRepository customerRepository){

        this.customerRepository =customerRepository;
    }

    @GetMapping
    public List<GetCustomerListResponse> getAll(){
        List<Customer> customerList= customerRepository.findAll();
        List<GetCustomerListResponse> getCustomerListResponses = new ArrayList<>();
        for (Customer customer: customerList){
            GetCustomerListResponse response=new GetCustomerListResponse();
            response.setDrivingLicanseNo(customer.getDrivingLicanseNo());
            response.setFirstName(customer.getFirstName());
            response.setLastName(customer.getLastName());
            response.setPhone(customer.getPhone());
            response.setEmail(customer.getEmail());
            getCustomerListResponses.add(response);
        }

        return getCustomerListResponses;
    }

    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id){

       Customer customer= customerRepository.findById(id).orElseThrow();
       GetCustomerResponse getCustomerResponse=new GetCustomerResponse();
       getCustomerResponse.setFirstName(customer.getFirstName());
       getCustomerResponse.setLastName(customer.getLastName());
       getCustomerResponse.setPhone(customer.getPhone());

       return getCustomerResponse;
    }
    @PostMapping
    public void add(@RequestBody AddCustomerRequest customerAdd){
        Customer customer=new Customer();
        customer.setFirstName(customerAdd.getFirstName());
        customer.setLastName(customerAdd.getLastName());
        customer.setPhone(customerAdd.getPhone());
        customerRepository.save(customer);

    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCustomerRequest updateCustomerRequest) throws Exception {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setDrivingLicanseNo(updateCustomerRequest.getDrivingLicanseNo());
            customer.setFirstName(updateCustomerRequest.getFirstName());
            customer.setLastName(updateCustomerRequest.getLastName());
            customer.setPhone(updateCustomerRequest.getPhone());
            customer.setEmail(updateCustomerRequest.getEmail());
            customerRepository.save(customer);
        } else {
            throw new Exception("Güncellenemedi.");
        }
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        customerRepository.deleteById(id);

    }

}

package com.tobeto.spring.java1b.services.concretes;

import com.tobeto.spring.java1b.entities.Customer;
import com.tobeto.spring.java1b.repositories.CustomerRepository;
import com.tobeto.spring.java1b.services.abstracts.CustomerService;
import com.tobeto.spring.java1b.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.java1b.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.java1b.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.customer.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public List<GetCustomerListResponse> getAll() {
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

    @Override
    public GetCustomerResponse getById(int id) {
        Customer customer= customerRepository.findById(id).orElseThrow();
        GetCustomerResponse getCustomerResponse=new GetCustomerResponse();
        getCustomerResponse.setFirstName(customer.getFirstName());
        getCustomerResponse.setLastName(customer.getLastName());
        getCustomerResponse.setPhone(customer.getPhone());

        return getCustomerResponse;
    }

    @Override
    public void add(AddCustomerRequest customerAdd) {
        Customer customer=new Customer();
        customer.setFirstName(customerAdd.getFirstName());
        customer.setLastName(customerAdd.getLastName());
        customer.setPhone(customerAdd.getPhone());
        customerRepository.save(customer);

    }

    @Override
    public void update(int id, UpdateCustomerRequest updateCustomerRequest) throws Exception {
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

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<GetCustomerListResponse> isNull() {
        List<Customer> customerList=customerRepository.findByEmailIsNull();
        List<GetCustomerListResponse> getCustomerListResponses=new ArrayList<>();
        for (Customer customer: customerList){
            GetCustomerListResponse responses =new GetCustomerListResponse();
            responses.setFirstName(customer.getFirstName());
            responses.setLastName(customer.getLastName());
            responses.setPhone(customer.getPhone());
            responses.setDrivingLicanseNo(customer.getDrivingLicanseNo());
            responses.setEmail(customer.getEmail());
            getCustomerListResponses.add(responses);
        }
        return getCustomerListResponses;
    }

    @Override
    public List<GetCustomerListResponse> ignoreName(String name) {
        List<Customer> customerList=customerRepository.findByFirstNameIgnoreCase(name);
        List<GetCustomerListResponse> getCustomerListResponses=new ArrayList<>();
        for (Customer customer:customerList){
            GetCustomerListResponse response=new GetCustomerListResponse();
            response.setFirstName(customer.getFirstName());
            response.setLastName(customer.getLastName());
            response.setPhone(customer.getPhone());
            response.setDrivingLicanseNo(customer.getDrivingLicanseNo());
            response.setEmail(customer.getEmail());
            getCustomerListResponses.add(response);
        }
        return getCustomerListResponses;
    }
}

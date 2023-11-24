package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.dtos.requests.address.AddAddressRequest;
import com.tobeto.spring.java1b.dtos.requests.address.UpdateAddressRequest;
import com.tobeto.spring.java1b.dtos.responses.address.GetAddressListResponse;
import com.tobeto.spring.java1b.dtos.responses.address.GetAddressResponse;
import com.tobeto.spring.java1b.entities.Address;
import com.tobeto.spring.java1b.entities.Car;
import com.tobeto.spring.java1b.repositories.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/adresses")
public class AddressesController {
    private final AddressRepository addressRepository;
    //final => ctor blok dışında set edemezsiniz.
    public AddressesController(AddressRepository addressRepository){

        this.addressRepository=addressRepository;
    }
    @GetMapping
    public List<GetAddressListResponse> getAll(){
        List<Address> addressList=addressRepository.findAll();
        List<GetAddressListResponse> getAddressListResponses =new ArrayList<>();
        for(Address address: addressList){
            GetAddressListResponse response=new GetAddressListResponse();
            response.setPostalCode(address.getPostalCode());
            response.setAddressText(address.getAddressText());
            getAddressListResponses.add(response);
        }


        return getAddressListResponses;
    }

    //Spring IoC container
    @GetMapping("{id}")
    public GetAddressResponse getById(@PathVariable int id){
        Address address=addressRepository.findById(id).orElseThrow();
        GetAddressResponse getAddressResponse=new GetAddressResponse();
        getAddressResponse.setAddressText(address.getAddressText());

        return getAddressResponse;
    }
    @PostMapping
    public void add(@RequestBody AddAddressRequest adressAdd){
        Address address=new Address();
        address.setPostalCode(adressAdd.getPostalCode());
        address.setAddressText(adressAdd.getAddressText());
        addressRepository.save(address);

        addressRepository.save(address);
    }
    @PutMapping
    public void update(@PathVariable int id,@RequestBody UpdateAddressRequest updateAddressRequest) throws Exception {
        Optional<Address> optionalAddress = addressRepository.findById(id);

        if (optionalAddress.isPresent()) {
            Address address = optionalAddress.get();
            address.setAddressText(updateAddressRequest.getAddressText());
            address.setPostalCode(updateAddressRequest.getPostalCode());
            addressRepository.save(address);
        } else {
            throw new Exception("Güncellenemedi.");
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){

        addressRepository.deleteById(id);

    }
}

package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.entities.Address;
import com.tobeto.spring.java1b.repositories.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/adresses")
public class AdressesController {
    private final AddressRepository addressRepository;
    //final => ctor blok dışında set edemezsiniz.
    public AdressesController(AddressRepository addressRepository){
        this.addressRepository=addressRepository;
    }
    @GetMapping
    public List<Address> getAll(){
        return addressRepository.findAll();
    }

    //Spring IoC container
    @GetMapping("{id}")
    public Address getById(@PathVariable int id){
        return addressRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Address address){
        addressRepository.save(address);
    }
    @PutMapping
    public void update(@RequestBody Address address){
        addressRepository.findById(address.getId()).orElseThrow();
        addressRepository.save(address);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){

        addressRepository.deleteById(id);

    }
}

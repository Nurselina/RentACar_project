package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.services.abstracts.AddressService;
import com.tobeto.spring.java1b.services.dtos.requests.address.AddAddressRequest;
import com.tobeto.spring.java1b.services.dtos.requests.address.UpdateAddressRequest;
import com.tobeto.spring.java1b.services.dtos.responses.address.GetAddressListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.address.GetAddressResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("api/adresses")
@AllArgsConstructor
public class AddressesController {
    private final AddressService addressService;
    //final => ctor blok dışında set edemezsiniz.

    @GetMapping
    public List<GetAddressListResponse> getAll(){

        return addressService.getAll();
    }

    //Spring IoC container
    @GetMapping("{id}")
    public GetAddressResponse getById(@PathVariable int id){

        return addressService.getById(id);
    }
    @PostMapping
    public void add(@RequestBody AddAddressRequest request){

        addressService.add(request);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody UpdateAddressRequest updateAddressRequest) throws Exception {
       addressService.update(id,updateAddressRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){

        addressService.delete(id);

    }
}

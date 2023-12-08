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
    @GetMapping("textPostaCode")
    public List<GetAddressListResponse> textPostaCode(@RequestParam String postalCode, String text) {

       return addressService.textPostaCode(postalCode, text);
    }

    @GetMapping("text")
    public GetAddressResponse text (@RequestParam String text){

        return addressService.text(text);
    }

    @GetMapping("findByAddressText")
    public List<GetAddressListResponse> findByAddressText(@RequestParam String addressText){
        return addressService.findByAddressText(addressText);
    }
    @GetMapping("postalCodeAndAddressText")
    public List<GetAddressListResponse> postalCodeAndAddressText(@RequestParam String postalCode, String addressText){
        return addressService.postalCodeAndAddressText(postalCode,addressText);
    }
}

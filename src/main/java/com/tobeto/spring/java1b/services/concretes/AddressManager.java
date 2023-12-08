package com.tobeto.spring.java1b.services.concretes;

import com.tobeto.spring.java1b.entities.Address;
import com.tobeto.spring.java1b.repositories.AddressRepository;
import com.tobeto.spring.java1b.services.abstracts.AddressService;
import com.tobeto.spring.java1b.services.dtos.requests.address.AddAddressRequest;
import com.tobeto.spring.java1b.services.dtos.requests.address.UpdateAddressRequest;
import com.tobeto.spring.java1b.services.dtos.responses.address.GetAddressListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.address.GetAddressResponse;
import com.tobeto.spring.java1b.services.dtos.responses.city.GetCityListResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {
    private final AddressRepository addressRepository;
    @Override
    public void add(AddAddressRequest request) {
        Address address=new Address();
        address.setPostalCode(request.getPostalCode());
        address.setAddressText(request.getAddressText());
        addressRepository.save(address);

        addressRepository.save(address);

    }

    @Override
    public List<GetAddressListResponse> getAll() {
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

    @Override
    public GetAddressResponse getById(int id) {
        Address address=addressRepository.findById(id).orElseThrow();
        GetAddressResponse getAddressResponse=new GetAddressResponse();
        getAddressResponse.setAddressText(address.getAddressText());

        return getAddressResponse;
    }

    @Override
    public void update(int id, UpdateAddressRequest updateAddressRequest) throws Exception {
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

    @Override
    public void delete(int id) {
        addressRepository.deleteById(id);

    }

    @Override
    public List<GetAddressListResponse> textPostaCode(String postalCode, String text) {
        List<Address> addressList=addressRepository.findByPostalCodeOrAddressText(postalCode,text);
        List<GetAddressListResponse> getAddressListResponses= new ArrayList<>();
        for (Address address:addressList){
            GetAddressListResponse response=new GetAddressListResponse();
            GetCityListResponse getCityListResponse=new GetCityListResponse(address.getCity().getName());
            response.setAddressText(address.getAddressText());
            response.setPostalCode(address.getPostalCode());
            response.setGetCityListResponse(getCityListResponse);
            getAddressListResponses.add(response);

        }
        return getAddressListResponses;
    }

    @Override
    public GetAddressResponse text(String text) {
        Address address=addressRepository.findByAddressTextIgnoreCase(text);
        GetAddressResponse getAddressResponse=new GetAddressResponse();
        getAddressResponse.setAddressText(address.getAddressText());
        return getAddressResponse ;

    }

   @Override
    public List<GetAddressListResponse> findByAddressText( String addressText) {
        return addressRepository.findByAddressText(addressText);
    }

    @Override
    public List<GetAddressListResponse> postalCodeAndAddressText(String postalCode, String addressText) {
        return addressRepository.findByPostalCodeAndAddressText(postalCode,addressText);
    }


}

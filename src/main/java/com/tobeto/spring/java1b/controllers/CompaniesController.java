package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.dtos.requests.company.AddCompanyRequest;
import com.tobeto.spring.java1b.dtos.requests.company.UpdateCompanyRequest;
import com.tobeto.spring.java1b.dtos.responses.company.GetCompanyListResponse;
import com.tobeto.spring.java1b.dtos.responses.company.GetCompanyResponse;
import com.tobeto.spring.java1b.entities.Car;
import com.tobeto.spring.java1b.entities.Company;
import com.tobeto.spring.java1b.repositories.CompanyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/companies")
public class CompaniesController {
    private final CompanyRepository companyRepository;

    public CompaniesController(CompanyRepository companyRepository){

        this.companyRepository =companyRepository;
    }

    @GetMapping
    public List<GetCompanyListResponse> getAll(){
        List<Company> companyList=companyRepository.findAll();
        List<GetCompanyListResponse> getCompanyListResponses =new ArrayList<>();
        for(Company company: companyList){
            GetCompanyListResponse response=new GetCompanyListResponse();
            response.setName(company.getName());
            response.setAddress(company.getAddress());
            response.setContactName(company.getContactName());
            response.setContactphone(company.getContactPhone());
            getCompanyListResponses.add(response);
        }

        return getCompanyListResponses;
    }

    @GetMapping("{id}")
    public GetCompanyResponse getById(@PathVariable int id){
        Company company= companyRepository .findById(id).orElseThrow();
        GetCompanyResponse getCompanyResponse =new GetCompanyResponse();
        getCompanyResponse.setContactName(company.getContactName());
        getCompanyResponse.setContactPhone(company.getContactPhone());
        return getCompanyResponse;
    }
    @PostMapping
    public void add(@RequestBody AddCompanyRequest companyAdd){
        Company company =new Company();
        company.setName(companyAdd.getName());
        company.setContactName(companyAdd.getContactName());
        company.setContactPhone(companyAdd.getContactPhone());
        companyRepository.save(company);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCompanyRequest updateCompanyRequest) throws Exception {
        Optional<Company> optionalCompany = companyRepository.findById(id);

        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            company.setName(updateCompanyRequest.getName());
            company.setAddress(updateCompanyRequest.getAddress());
            company.setContactName(updateCompanyRequest.getContactName());
            company.setContactPhone(updateCompanyRequest.getContactPhone());
            companyRepository.save(company);
        } else {
            throw new Exception("Güncellenemedi.");
        }
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        companyRepository.deleteById(id);

    }
}

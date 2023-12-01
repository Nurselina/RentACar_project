package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.services.abstracts.CompanyService;
import com.tobeto.spring.java1b.services.dtos.requests.company.AddCompanyRequest;
import com.tobeto.spring.java1b.services.dtos.requests.company.UpdateCompanyRequest;
import com.tobeto.spring.java1b.services.dtos.responses.company.GetCompanyListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.company.GetCompanyResponse;
import com.tobeto.spring.java1b.entities.Company;
import com.tobeto.spring.java1b.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/companies")
@AllArgsConstructor
public class CompaniesController {

    private final CompanyService companyService;


    @GetMapping
    public List<GetCompanyListResponse> getAll(){
       return companyService.getAll();
    }

    @GetMapping("{id}")
    public GetCompanyResponse getById(@PathVariable int id){
       return companyService.getById(id);
    }
    @PostMapping
    public void add(@RequestBody AddCompanyRequest companyAdd){
       companyService.add(companyAdd);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCompanyRequest updateCompanyRequest) throws Exception {
       companyService.update(id,updateCompanyRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        companyService.delete(id);

    }
}

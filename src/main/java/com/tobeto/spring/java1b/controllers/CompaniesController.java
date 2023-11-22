package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.entities.Company;
import com.tobeto.spring.java1b.repositories.CompanyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/companies")
public class CompaniesController {
    private final CompanyRepository companyRepository;

    public CompaniesController(CompanyRepository companyRepository){
        this.companyRepository =companyRepository;
    }

    @GetMapping
    public List<Company> getAll(){
        return companyRepository.findAll();
    }

    @GetMapping("{id}")
    public Company getById(@PathVariable int id){
        return companyRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Company company){
        companyRepository.save(company);
    }
    @PutMapping("{id}")
    public void update(@RequestBody Company company){
        companyRepository.findById(company.getId()).orElseThrow();
        companyRepository.save(company);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        companyRepository.deleteById(id);

    }
}

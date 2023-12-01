package com.tobeto.spring.java1b.services.concretes;

import com.tobeto.spring.java1b.entities.Company;
import com.tobeto.spring.java1b.repositories.CompanyRepository;
import com.tobeto.spring.java1b.services.abstracts.CompanyService;
import com.tobeto.spring.java1b.services.dtos.requests.company.AddCompanyRequest;
import com.tobeto.spring.java1b.services.dtos.requests.company.UpdateCompanyRequest;
import com.tobeto.spring.java1b.services.dtos.responses.company.GetCompanyListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.company.GetCompanyResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyManager implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public List<GetCompanyListResponse> getAll() {
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

    @Override
    public GetCompanyResponse getById(int id) {
        Company company= companyRepository .findById(id).orElseThrow();
        GetCompanyResponse getCompanyResponse =new GetCompanyResponse();
        getCompanyResponse.setContactName(company.getContactName());
        getCompanyResponse.setContactPhone(company.getContactPhone());
        return getCompanyResponse;
    }

    @Override
    public void add(AddCompanyRequest companyAdd) {
        Company company =new Company();
        company.setName(companyAdd.getName());
        company.setContactName(companyAdd.getContactName());
        company.setContactPhone(companyAdd.getContactPhone());
        companyRepository.save(company);
    }

    @Override
    public void update(int id, UpdateCompanyRequest updateCompanyRequest) throws Exception {
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

    @Override
    public void delete(int id) {
        companyRepository.deleteById(id);
    }
}

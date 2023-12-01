package com.tobeto.spring.java1b.services.abstracts;

import com.tobeto.spring.java1b.services.dtos.requests.company.AddCompanyRequest;
import com.tobeto.spring.java1b.services.dtos.requests.company.UpdateCompanyRequest;
import com.tobeto.spring.java1b.services.dtos.responses.company.GetCompanyListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.company.GetCompanyResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CompanyService {
    List<GetCompanyListResponse> getAll();
    GetCompanyResponse getById(int id);
    void add(AddCompanyRequest companyAdd);
    void update(int id, UpdateCompanyRequest updateCompanyRequest) throws Exception;
    void delete(int id);
}

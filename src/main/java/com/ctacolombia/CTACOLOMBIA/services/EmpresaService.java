package com.ctacolombia.CTACOLOMBIA.services;

import com.ctacolombia.CTACOLOMBIA.dto.entity.Empresa;
import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface EmpresaService {

    GeneralResponse findPageable(Integer page, Integer pageSize);
    
    GeneralResponse findById(String nit);

    GeneralResponse createEmpresa(Empresa empresa);

    GeneralResponse updateEmpresa(Empresa empresa);

}

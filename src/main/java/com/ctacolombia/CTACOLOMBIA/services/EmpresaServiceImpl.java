package com.ctacolombia.CTACOLOMBIA.services;

import com.ctacolombia.CTACOLOMBIA.dto.entity.Empresa;
import com.ctacolombia.CTACOLOMBIA.dto.repository.EmpresaRepository;
import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;
import com.ctacolombia.CTACOLOMBIA.util.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;


    @Override
    public GeneralResponse findPageable(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Empresa> empresaPage = empresaRepository.findByOrderByEmpresaNombreAsc(pageable);
        if (empresaPage.isEmpty()) {
            return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.NO_DATA_MESSAGE, false, null);
        }
        return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_MESSAGE, true, empresaPage);
    }

    @Override
    public GeneralResponse findById(String nit) {
        Optional<Empresa> empresa = empresaRepository.findById(nit);
        if (empresa.isEmpty()) {
            return GeneralResponse.buildResponseGeneral(HttpStatus.BAD_REQUEST, Constants.NO_DATA_MESSAGE, false, null);
        }
        return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_MESSAGE, true, empresa.get());
    }

    @Override
    public GeneralResponse createEmpresa(Empresa empresa) {
        Empresa empresaNew = null;

        if (empresaRepository.existsByEmpresaNit(empresa.getEmpresaNit())) {
            return GeneralResponse.buildResponseGeneral(HttpStatus.BAD_REQUEST, Constants.EMPRESA_EXISTS, false, null);
        }

        empresaNew = empresaRepository.save(empresa);
        return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_SAVED, true, empresaNew);
    }

    @Override
    public GeneralResponse updateEmpresa(Empresa empresa) {
        Empresa empresaNew = null;

        try {
            empresaNew = empresaRepository.save(empresa);
        }catch (DataAccessException e){
            return GeneralResponse.buildResponseGeneral(HttpStatus.BAD_REQUEST, e.getMostSpecificCause().getMessage(), false, null);
        }

        return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_SAVED, true, empresaNew);
    }
}

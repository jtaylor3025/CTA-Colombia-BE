package com.ctacolombia.CTACOLOMBIA.services;

import com.ctacolombia.CTACOLOMBIA.dto.entity.Programa;
import com.ctacolombia.CTACOLOMBIA.dto.repository.ProgramaRepository;
import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;
import com.ctacolombia.CTACOLOMBIA.util.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProgramaServiceImpl implements ProgramaService{
    @Autowired
    ProgramaRepository programaRepository;

    @Override
    public GeneralResponse findAllProgramas(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Programa> programaPage = programaRepository.findAll(pageable);
        if(programaPage.isEmpty()) return GeneralResponse.buildResponseGeneral(HttpStatus.BAD_REQUEST, Constants.NO_DATA_MESSAGE, false, null);
        return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_MESSAGE, true, programaPage);
    }
}

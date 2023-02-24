package com.ctacolombia.CTACOLOMBIA.services;

import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;

public interface ProgramaService {
    GeneralResponse findAllProgramas(Integer page, Integer pageSize);
}

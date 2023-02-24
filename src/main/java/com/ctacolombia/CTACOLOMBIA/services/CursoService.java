package com.ctacolombia.CTACOLOMBIA.services;

import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;

public interface CursoService {
    GeneralResponse findCursosPage(Integer page, Integer pageSize);
}

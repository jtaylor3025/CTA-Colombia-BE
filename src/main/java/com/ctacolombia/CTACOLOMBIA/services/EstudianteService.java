package com.ctacolombia.CTACOLOMBIA.services;

import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;

public interface EstudianteService {
    GeneralResponse findPageEstudiantes(Integer page, Integer pageSize);
    GeneralResponse findEstudianteById(String estudianteDocumento);
}

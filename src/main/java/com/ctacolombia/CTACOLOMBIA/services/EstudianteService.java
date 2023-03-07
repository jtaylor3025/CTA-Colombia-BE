package com.ctacolombia.CTACOLOMBIA.services;

import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;
import jxl.read.biff.BiffException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

public interface EstudianteService {
    GeneralResponse findPageEstudiantes(Integer page, Integer pageSize);
    GeneralResponse findEstudianteById(String estudianteDocumento);
    GeneralResponse insertEstudianteBulk(MultipartFile file) throws IOException, BiffException, ParseException;
}

package com.ctacolombia.CTACOLOMBIA.services;

import com.ctacolombia.CTACOLOMBIA.dto.entity.Estudiante;
import com.ctacolombia.CTACOLOMBIA.dto.repository.EstudianteRepository;
import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;
import com.ctacolombia.CTACOLOMBIA.util.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public GeneralResponse findPageEstudiantes(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Estudiante> estudiantePage = estudianteRepository.findAll(pageable);
        return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_MESSAGE, true, estudiantePage);
    }

    @Override
    public GeneralResponse findEstudianteById(String estudianteDocumento) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(estudianteDocumento);
        if(estudiante.isPresent())
            return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_MESSAGE, true, estudiante.get());
        return GeneralResponse.buildResponseGeneral(HttpStatus.BAD_REQUEST, Constants.NO_DATA_MESSAGE, false, null);
    }
}

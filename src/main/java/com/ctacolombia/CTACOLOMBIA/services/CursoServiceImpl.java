package com.ctacolombia.CTACOLOMBIA.services;

import com.ctacolombia.CTACOLOMBIA.dto.entity.Curso;
import com.ctacolombia.CTACOLOMBIA.dto.repository.CursoRepository;
import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;
import com.ctacolombia.CTACOLOMBIA.util.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl implements CursoService{
    @Autowired
    CursoRepository cursoRepository;
    @Override
    public GeneralResponse findCursosPage(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Curso> cursoPage = cursoRepository.findAll(pageable);
        if(cursoPage.isEmpty()) return GeneralResponse.buildResponseGeneral(HttpStatus.BAD_REQUEST, Constants.NO_DATA_MESSAGE, false, null);
        return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_MESSAGE, true, cursoPage);
    }

    @Override
    public GeneralResponse createCurso(Curso curso) {
        if(!curso.equals(null)) return GeneralResponse.buildResponseGeneral(HttpStatus.BAD_REQUEST, Constants.CURSO_INCOMPLETO, false, null);
        Curso cursoSaved = cursoRepository.save(curso);
        return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_SAVED, true, cursoSaved);
    }
}

package com.ctacolombia.CTACOLOMBIA.services;

import com.ctacolombia.CTACOLOMBIA.dto.entity.Pais;
import com.ctacolombia.CTACOLOMBIA.dto.repository.PaisRepository;
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
public class PaisServiceImpl implements PaisService{
    @Autowired
    PaisRepository paisRepository;
    @Override
    public GeneralResponse findPagePais(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Pais> paisPage = paisRepository.findAll(pageable);
        if(paisPage.getContent().isEmpty()) return GeneralResponse.buildResponseGeneral(HttpStatus.BAD_REQUEST, Constants.NO_DATA_MESSAGE, false, null);
        return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_MESSAGE, true, paisPage);
    }

    @Override
    public GeneralResponse createPais(Pais pais) {
        if(paisRepository.existsByPaisNombre(pais.getPaisNombre())) return GeneralResponse.buildResponseGeneral(HttpStatus.BAD_REQUEST, Constants.PAIS_EXISTS, false, null);
        Pais paisNuevo = paisRepository.save(pais);
        return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_SAVED, true, paisNuevo);
    }

    @Override
    public GeneralResponse updatePais(Pais pais) {
        if(pais.equals(null)) return GeneralResponse.buildResponseGeneral(HttpStatus.BAD_REQUEST, Constants.NO_DATA_MESSAGE, false, null);
        Pais paisUpdated = paisRepository.save(pais);
        return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_SAVED, true, paisUpdated);
    }

    @Override
    public GeneralResponse findPais(Long paisId) {
        if(!paisId.equals(null)){
            Optional<Pais> pais = paisRepository.findById(paisId);
            if(pais.isPresent()) return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_MESSAGE, true, pais.get());
            return GeneralResponse.buildResponseGeneral(HttpStatus.BAD_REQUEST, Constants.NO_DATA_MESSAGE, true, paisId);
        }
        return null;
    }
}

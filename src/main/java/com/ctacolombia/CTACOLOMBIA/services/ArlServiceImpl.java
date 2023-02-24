package com.ctacolombia.CTACOLOMBIA.services;

import com.ctacolombia.CTACOLOMBIA.dto.entity.Arl;
import com.ctacolombia.CTACOLOMBIA.dto.repository.ArlRepository;
import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;
import com.ctacolombia.CTACOLOMBIA.util.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArlServiceImpl implements ArlService{
    @Autowired
    private ArlRepository arlRepository;

    @Override
    public GeneralResponse findPage(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Arl> arlPage = arlRepository.findByOrderByArlIdAsc(pageable);
        if(arlPage.isEmpty()){
            return GeneralResponse.buildResponseGeneral(HttpStatus.BAD_REQUEST, Constants.NO_DATA_MESSAGE, false, null);
        }
        return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_MESSAGE, true, arlPage);
    }

    @Override
    public GeneralResponse findArlById(Long arlId) {
        Optional<Arl> arl = arlRepository.findByArlId(arlId);
        if(arl.isPresent()){
            return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_MESSAGE, true, arl.get());
        }
        return GeneralResponse.buildResponseGeneral(HttpStatus.BAD_REQUEST, Constants.NO_DATA_MESSAGE, false, null);
    }

    @Override
    public GeneralResponse createArl(Arl arl) {
        Arl arlNew = null;
        if(arlRepository.existsByArlNombre(arl.getArlNombre())) return GeneralResponse.buildResponseGeneral(HttpStatus.BAD_REQUEST, Constants.ARL_EXISTS, false, null);
        if(!arl.getArlNombre().isEmpty()) arlNew = arlRepository.save(arl);
        return GeneralResponse.buildResponseGeneral(HttpStatus.CREATED, Constants.SUCCES_MESSAGE, true, arlNew);
    }

    @Override
    public GeneralResponse updateArl(Arl arl) {
        Arl arlNew = null;
        try {
            arlNew = arlRepository.save(arl);
        }catch (DataAccessException e){
            return GeneralResponse.buildResponseGeneral(HttpStatus.BAD_REQUEST, e.getMostSpecificCause().getMessage(), false, null);
        }
        return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_SAVED, true, arlNew);
    }
}

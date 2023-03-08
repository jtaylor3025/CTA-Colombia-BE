package com.ctacolombia.CTACOLOMBIA.services;

import com.ctacolombia.CTACOLOMBIA.dto.entity.TipoDocumento;
import com.ctacolombia.CTACOLOMBIA.dto.repository.TipoDocumentoRepository;
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
public class TipoDocumentoServiceImpl implements TipoDocumentoService {
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public GeneralResponse findTipoDocuPage(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<TipoDocumento> tipoDocumentoPageable = tipoDocumentoRepository.findAll(pageable);
        if (tipoDocumentoPageable.getContent().isEmpty())
            return GeneralResponse.buildResponseGeneral(HttpStatus.BAD_REQUEST, Constants.NO_DATA_MESSAGE, false, null);
        return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_MESSAGE, true, tipoDocumentoPageable);
    }

    @Override
    public GeneralResponse findTipoDocu(Long tipodocuId) {
        if (!tipodocuId.equals(null)) {
            Optional<TipoDocumento> tipoDocumento = tipoDocumentoRepository.findById(tipodocuId);
            if (tipoDocumento.isPresent())
                return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_MESSAGE, true, tipoDocumento.get());
            return GeneralResponse.buildResponseGeneral(HttpStatus.BAD_REQUEST, Constants.NO_DATA_MESSAGE, false, null);
        }
        return null;
    }

    @Override
    public GeneralResponse createTipoDocu(TipoDocumento tipoDocumento) {
        TipoDocumento tipoDocumentoSaved;
        try {
            tipoDocumentoSaved = tipoDocumentoRepository.save(tipoDocumento);
        }catch (DataAccessException e){
            return GeneralResponse.buildResponseGeneral(HttpStatus.BAD_REQUEST, e.getMostSpecificCause().getMessage(), false, null);
        }
        return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_MESSAGE, true, tipoDocumentoSaved);
    }

    @Override
    public GeneralResponse updateTipoDocu(TipoDocumento tipoDocumento) {
        TipoDocumento tipoDocumentoUpdated;
        try {
            tipoDocumentoUpdated = tipoDocumentoRepository.save(tipoDocumento);
        } catch (DataAccessException e) {
            return GeneralResponse.buildResponseGeneral(HttpStatus.BAD_REQUEST, e.getMostSpecificCause().getMessage(), false, null);
        }
        return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_SAVED, true, tipoDocumentoUpdated);
    }
}

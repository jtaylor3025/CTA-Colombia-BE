package com.ctacolombia.CTACOLOMBIA.services;

import com.ctacolombia.CTACOLOMBIA.dto.entity.TipoDocumento;
import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;

public interface TipoDocumentoService {
    GeneralResponse findTipoDocuPage(Integer page, Integer pageSize);
    GeneralResponse findTipoDocu(Long tipodocuId);
    GeneralResponse createTipoDocu(TipoDocumento tipoDocumento);
    GeneralResponse updateTipoDocu(TipoDocumento tipoDocumento);
}

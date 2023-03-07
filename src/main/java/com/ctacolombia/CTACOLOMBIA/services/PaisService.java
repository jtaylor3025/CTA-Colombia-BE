package com.ctacolombia.CTACOLOMBIA.services;

import com.ctacolombia.CTACOLOMBIA.dto.entity.Pais;
import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;

public interface PaisService {
    GeneralResponse findPagePais(Integer page, Integer pageSize);

    GeneralResponse createPais(Pais pais);

    GeneralResponse updatePais(Pais pais);

    GeneralResponse findPais(Long paisId);
}

package com.ctacolombia.CTACOLOMBIA.services;

import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;

public interface PaisService {
    GeneralResponse findPagePais(Integer page, Integer pageSize);
}

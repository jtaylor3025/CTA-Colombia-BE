package com.ctacolombia.CTACOLOMBIA.services;

import com.ctacolombia.CTACOLOMBIA.dto.entity.Arl;
import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;

public interface ArlService {

    GeneralResponse findPage(Integer page, Integer pageSize);
    GeneralResponse findArlById(Long arlId);
    GeneralResponse createArl(Arl arl);
    GeneralResponse updateArl(Arl arl);
}

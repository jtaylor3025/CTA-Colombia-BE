package com.ctacolombia.CTACOLOMBIA.services;

import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;

import javax.persistence.GeneratedValue;

public interface CertificadoService {
    GeneralResponse findCertificadosPage(Integer page, Integer pageSize);
}

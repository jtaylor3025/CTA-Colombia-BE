package com.ctacolombia.CTACOLOMBIA.controllers;

import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;
import com.ctacolombia.CTACOLOMBIA.services.CertificadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CertificadoController {
    @Autowired
    CertificadoService certificadoService;

    @GetMapping("/certificados/page")
    public ResponseEntity<Object> findCertificadosPage(@RequestParam Integer page, Integer pageSize){
        GeneralResponse generalResponse = certificadoService.findCertificadosPage(page, pageSize);
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }
}

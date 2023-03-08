package com.ctacolombia.CTACOLOMBIA.controllers;

import com.ctacolombia.CTACOLOMBIA.dto.entity.TipoDocumento;
import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;
import com.ctacolombia.CTACOLOMBIA.services.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tipodocu")
public class TipoDocumentoController {
    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping("/page")
    public ResponseEntity<Object> findTipoDocuPage(@RequestParam Integer page, @RequestParam Integer pageSize){
        GeneralResponse generalResponse = tipoDocumentoService.findTipoDocuPage(page, pageSize);
        return new ResponseEntity<>(generalResponse, HttpStatus.valueOf(generalResponse.getCode()));
    }

    @GetMapping("/id")
    public ResponseEntity<Object> findTipoDocuId(@RequestParam Long tipodocuId){
        GeneralResponse generalResponse = tipoDocumentoService.findTipoDocu(tipodocuId);
        return new ResponseEntity<>(generalResponse, HttpStatus.valueOf(generalResponse.getCode()));
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createTipoDocu(@RequestBody TipoDocumento tipoDocumento){
        GeneralResponse generalResponse = tipoDocumentoService.createTipoDocu(tipoDocumento);
        return new ResponseEntity<>(generalResponse, HttpStatus.valueOf(generalResponse.getCode()));
    }

    @PostMapping("/update")
    public ResponseEntity<Object> updateTipoDocu(@RequestBody TipoDocumento tipoDocumento){
        GeneralResponse generalResponse = tipoDocumentoService.updateTipoDocu(tipoDocumento);
        return new ResponseEntity<>(generalResponse, HttpStatus.valueOf(generalResponse.getCode()));
    }
}

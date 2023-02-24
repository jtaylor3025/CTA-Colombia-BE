package com.ctacolombia.CTACOLOMBIA.controllers;

import com.ctacolombia.CTACOLOMBIA.dto.entity.Empresa;
import com.ctacolombia.CTACOLOMBIA.dto.repository.EmpresaRepository;
import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;
import com.ctacolombia.CTACOLOMBIA.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/empresas/page")
    public ResponseEntity<Object> getEmpresaPage(@RequestParam Integer page, @RequestParam Integer pageSize) {
        GeneralResponse generalResponse = empresaService.findPageable(page, pageSize);
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @GetMapping("/empresas/nit")
    public ResponseEntity<Object> getEmpresaByNit(@RequestParam String empresaNit) {
        GeneralResponse generalResponse = empresaService.findById(empresaNit);
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @PostMapping("/empresa")
    public ResponseEntity<Object> createEmpresa(@RequestBody Empresa empresa) {
        GeneralResponse generalResponse = empresaService.createEmpresa(empresa);
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);

    }

    @PostMapping("/empresa/actualizar")
    public ResponseEntity<Object> actualizarEmpresa(@RequestBody Empresa empresa) {
        GeneralResponse generalResponse = empresaService.updateEmpresa(empresa);
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }
}

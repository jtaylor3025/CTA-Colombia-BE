package com.ctacolombia.CTACOLOMBIA.controllers;

import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;
import com.ctacolombia.CTACOLOMBIA.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pais")
public class PaisController {
    @Autowired
    private PaisService paisService;

    @GetMapping("/page")
    public ResponseEntity<Object> findEstudiantesPage(@RequestParam Integer page, @RequestParam Integer pageSize){
        GeneralResponse generalResponse = paisService.findPagePais(page, pageSize);
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }
}

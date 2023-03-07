package com.ctacolombia.CTACOLOMBIA.controllers;

import com.ctacolombia.CTACOLOMBIA.dto.entity.Pais;
import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;
import com.ctacolombia.CTACOLOMBIA.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pais")
public class PaisController {
    @Autowired
    private PaisService paisService;

    @GetMapping("/page")
    public ResponseEntity<Object> findPaisPage(@RequestParam Integer page, @RequestParam Integer pageSize){
        GeneralResponse generalResponse = paisService.findPagePais(page, pageSize);
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Object> findPaisId(@RequestParam Long paisId){
        GeneralResponse generalResponse = paisService.findPais(paisId);
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createPais(@RequestBody Pais pais){
        GeneralResponse generalResponse = paisService.createPais(pais);
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> updatePais(@RequestBody Pais pais){
        GeneralResponse generalResponse = paisService.updatePais(pais);
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }
}

package com.ctacolombia.CTACOLOMBIA.controllers;

import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;
import com.ctacolombia.CTACOLOMBIA.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/page")
    public ResponseEntity<Object> findEstudiantesPage(@RequestParam Integer page,@RequestParam Integer pageSize){
        GeneralResponse generalResponse = estudianteService.findPageEstudiantes(page, pageSize);
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @GetMapping("/documento")
    public ResponseEntity<Object> findEstudianteById(@RequestParam String documento){
        GeneralResponse generalResponse = estudianteService.findEstudianteById(documento);
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }
}

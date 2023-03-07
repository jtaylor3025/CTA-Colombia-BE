package com.ctacolombia.CTACOLOMBIA.controllers;

import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;
import com.ctacolombia.CTACOLOMBIA.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    @PostMapping("/bulkinsert")
    public ResponseEntity<Object> bulkInsertEstudiantes(@RequestParam("file") MultipartFile file) throws IOException{
        GeneralResponse generalResponse = null;
        try {
            generalResponse = estudianteService.insertEstudianteBulk(file);
        } catch (jxl.read.biff.BiffException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }
}

package com.ctacolombia.CTACOLOMBIA.controllers;

import com.ctacolombia.CTACOLOMBIA.dto.entity.Arl;
import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;
import com.ctacolombia.CTACOLOMBIA.services.ArlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class ArlController {

    @Autowired
    private ArlService arlService;

    @GetMapping("/arl/page")
    public ResponseEntity<Object> findArlPage(@RequestParam Integer page, @RequestParam Integer pageSize){
        GeneralResponse generalResponse = arlService.findPage(page, pageSize);
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @GetMapping("/arl/id")
    public ResponseEntity<Object> findArlById(@RequestParam Long arlId){
        GeneralResponse generalResponse = arlService.findArlById(arlId);
        return new ResponseEntity<>(generalResponse,HttpStatus.OK);
    }

    @PostMapping("/arl")
    public ResponseEntity<Object> createArl(@RequestBody Arl arl){
        GeneralResponse generalResponse = arlService.createArl(arl);
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @PostMapping("/arl/actualizar")
    public ResponseEntity<Object> updateArl(@RequestBody Arl arl){
        GeneralResponse generalResponse = arlService.updateArl(arl);
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }
}

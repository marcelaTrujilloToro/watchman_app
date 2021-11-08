package com.umanizales.watchman_app.infrastructure.controllers;

import com.umanizales.watchman_app.aplication.LocationImpl;
import com.umanizales.watchman_app.domain.LocationDTO;
import com.umanizales.watchman_app.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "location")
public class LocationController {

    @Autowired
    private LocationImpl locationImpl;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid LocationDTO locationDTO){
        return new ResponseEntity<>(new ResponseDTO("success",
                locationImpl.save(locationDTO), null), HttpStatus.OK);
    }
}

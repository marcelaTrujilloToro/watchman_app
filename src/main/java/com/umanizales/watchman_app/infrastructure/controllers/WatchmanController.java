package com.umanizales.watchman_app.infrastructure.controllers;

import com.umanizales.watchman_app.aplication.WatchmanImpl;
import com.umanizales.watchman_app.domain.WatchmanDTO;
import com.umanizales.watchman_app.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "watchman")
public class WatchmanController {

    @Autowired
    private WatchmanImpl watchmanImpl;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid WatchmanDTO watchmanDTO){
        return new ResponseEntity<>(new ResponseDTO("success",
                watchmanImpl.save(watchmanDTO), null), HttpStatus.OK);
    }
}

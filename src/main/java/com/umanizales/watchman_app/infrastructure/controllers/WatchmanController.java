package com.umanizales.watchman_app.infrastructure.controllers;

import com.umanizales.watchman_app.aplication.WatchmanImpl;
import com.umanizales.watchman_app.domain.WatchmanDTO;
import com.umanizales.watchman_app.exception.WatchmanAppException;
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

    @PutMapping("{code}")
    ResponseEntity<ResponseDTO> updateWatchman(@PathVariable int code, @RequestBody @Valid WatchmanDTO watchmanDTO) throws WatchmanAppException {
        return new ResponseEntity<>(new ResponseDTO("success",
                watchmanImpl.update(code, watchmanDTO), null), HttpStatus.OK);
    }

    @DeleteMapping("{code}")
    public @ResponseBody
    ResponseEntity<ResponseDTO> deleteWatchman(@PathVariable int code) throws WatchmanAppException {
        return  new ResponseEntity<ResponseDTO>(
                new ResponseDTO("Success", watchmanImpl.delete(code), null), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list(){
        return new ResponseEntity<>(new ResponseDTO("Success",
                watchmanImpl.list(), null), HttpStatus.OK );
    }
}

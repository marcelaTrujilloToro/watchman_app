package com.umanizales.watchman_app.aplication;

import com.umanizales.watchman_app.domain.WatchmanDTO;
import com.umanizales.watchman_app.exception.WatchmanAppException;

import java.util.List;

public interface WatchmanAble {
    //acciones que va a realizar el microservicio sobre el watchman
    WatchmanDTO save(WatchmanDTO watchmanDTO);
    WatchmanDTO update(int code, WatchmanDTO watchmanDTO) throws WatchmanAppException;
    boolean delete(int code) throws WatchmanAppException;
    List<WatchmanDTO> list();
}

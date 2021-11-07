package com.umanizales.watchman_app.aplication;

import com.umanizales.watchman_app.domain.WatchmanDTO;
import java.util.List;

public interface WatchmanAble {
    //acciones que va a realizar el microservicio sobre el watchman
    WatchmanDTO save(WatchmanDTO watchmanDTO);
    WatchmanDTO update(WatchmanDTO watchmanDTO);
    boolean delete(int code);
    List<WatchmanDTO> list();
}

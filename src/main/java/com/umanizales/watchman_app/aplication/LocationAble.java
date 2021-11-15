package com.umanizales.watchman_app.aplication;


import com.umanizales.watchman_app.domain.LocationDTO;
import com.umanizales.watchman_app.exception.WatchmanAppException;

import java.util.List;

public interface LocationAble {
    LocationDTO save(LocationDTO locationDTO);
    LocationDTO update(int code, LocationDTO locationDTO) throws WatchmanAppException;
    boolean delete(int code) throws WatchmanAppException;
    List<LocationDTO> list();
}

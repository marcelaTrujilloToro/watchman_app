package com.umanizales.watchman_app.aplication;


import com.umanizales.watchman_app.domain.LocationDTO;

import java.util.List;

public interface LocationAble {
    LocationDTO save(LocationDTO locationDTO);
    LocationDTO update(LocationDTO locationDTO);
    boolean delete(int code);
    List<LocationDTO> list();
}

package com.umanizales.watchman_app.aplication;

import com.umanizales.watchman_app.domain.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationImpl implements LocationAble {

    @Autowired
    @Qualifier("PostgresLocationRepository")
    private LocationAble locationPersistance;

    @Override
    public LocationDTO save(LocationDTO locationDTO) {
        return locationPersistance.save(locationDTO);
    }

    @Override
    public LocationDTO update(LocationDTO locationDTO) {
        return null;
    }

    @Override
    public boolean delete(int code) {
        return false;
    }

    @Override
    public List<LocationDTO> list() {
        return null;
    }
}

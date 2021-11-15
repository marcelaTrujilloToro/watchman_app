package com.umanizales.watchman_app.aplication;

import com.umanizales.watchman_app.domain.LocationDTO;
import com.umanizales.watchman_app.exception.WatchmanAppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationImpl implements LocationAble {

    @Autowired
    @Qualifier("PostgresLocationRepository")
    private LocationAble locationPersistence;

    @Override
    public LocationDTO save(LocationDTO locationDTO) {
        return locationPersistence.save(locationDTO);
    }

    @Override
    public LocationDTO update(int code, LocationDTO locationDTO) throws WatchmanAppException{
        return locationPersistence.update(code, locationDTO);
    }

    @Override
    public boolean delete(int code) throws WatchmanAppException {
        return locationPersistence.delete((code));
    }

    @Override
    public List<LocationDTO> list() {
        return locationPersistence.list();
    }
}

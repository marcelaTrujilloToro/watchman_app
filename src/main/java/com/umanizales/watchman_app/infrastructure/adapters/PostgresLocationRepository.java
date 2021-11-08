package com.umanizales.watchman_app.infrastructure.adapters;

import com.umanizales.watchman_app.aplication.LocationAble;
import com.umanizales.watchman_app.domain.LocationDTO;
import com.umanizales.watchman_app.infrastructure.repositories.entity.LocationEntity;
import com.umanizales.watchman_app.infrastructure.repositories.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Qualifier("PostgresLocationRepository")
@Repository("LocationPersistance")
public class PostgresLocationRepository implements LocationAble {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public LocationDTO save(LocationDTO locationDTO) {
        return locationRepository.save(new LocationEntity(locationDTO)).toLocationDTO();
    }

    @Override
    public LocationDTO update(LocationDTO locationDTO) {
        return locationRepository.save(new LocationEntity(locationDTO)).toLocationDTO();
    }

    @Override
    public boolean delete(int code) {
        locationRepository.deleteAllById(Collections.singleton(code));
        return false;
    }

    @Override
    public List<LocationDTO> list() {
        return null;
    }
}

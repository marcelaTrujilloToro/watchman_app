package com.umanizales.watchman_app.infrastructure.adapters;

import com.umanizales.watchman_app.aplication.LocationAble;
import com.umanizales.watchman_app.domain.LocationDTO;
import com.umanizales.watchman_app.exception.WatchmanAppException;
import com.umanizales.watchman_app.infrastructure.repositories.entity.LocationEntity;
import com.umanizales.watchman_app.infrastructure.repositories.entity.WatchmanEntity;
import com.umanizales.watchman_app.infrastructure.repositories.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Qualifier("PostgresLocationRepository")
@Repository("LocationPersistence")
public class PostgresLocationRepository implements LocationAble {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public LocationDTO save(LocationDTO locationDTO) {
        return locationRepository.save(new LocationEntity(locationDTO)).toLocationDTO();
    }

    @Override
    public LocationDTO update(int code, LocationDTO locationDTO) throws WatchmanAppException{
        if (locationRepository.existsById(code)){
            return locationRepository.save(new LocationEntity(locationDTO)).toLocationDTO();
        }
        else {
            throw new WatchmanAppException("El codigo a editar no existe: " + code);
        }
    }

    @Override
    public boolean delete(int code) throws WatchmanAppException {
        if (locationRepository.existsById(code)){
            try{locationRepository.deleteAllById(Collections.singleton(code));
            return true;
            }
            catch (Exception e){
                throw new WatchmanAppException("Este location no se puede eliminar, tiene relaciones: " + code);
            }
        }
        else {
            throw new WatchmanAppException("El codigo a borrar no existe: " + code);
        }
    }

    @Override
    public List<LocationDTO> list() {
        List<LocationEntity> locationEntities = locationRepository.findAll();
        List<LocationDTO> locationDTOS = new ArrayList<>();
        for (LocationEntity location: locationEntities) {
            locationDTOS.add((location.toLocationDTO()));
        }
        return locationDTOS;
    }
}

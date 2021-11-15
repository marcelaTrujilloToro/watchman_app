package com.umanizales.watchman_app.infrastructure.adapters;

import com.umanizales.watchman_app.aplication.WatchmanAble;
import com.umanizales.watchman_app.domain.WatchmanDTO;
import com.umanizales.watchman_app.exception.WatchmanAppException;
import com.umanizales.watchman_app.infrastructure.repositories.entity.WatchmanEntity;
import com.umanizales.watchman_app.infrastructure.repositories.repository.WatchmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Qualifier("PostgresWatchmanRepository")
@Repository("WatchmanPersistence")
public class PostgresWatchmanRepository implements WatchmanAble {

    //inyeccion de dependencias
    @Autowired
    private WatchmanRepository watchmanRepository;

    @Override
    public WatchmanDTO save(WatchmanDTO watchmanDTO) {

       return watchmanRepository.save(new WatchmanEntity(watchmanDTO)).toWatchmanDTO();
    }

    @Override
    public WatchmanDTO update(int code, WatchmanDTO watchmanDTO) throws WatchmanAppException {
        if (watchmanRepository.existsById(code)){
             return watchmanRepository.save(new WatchmanEntity(watchmanDTO)).toWatchmanDTO();
        }
        else {
            throw new WatchmanAppException("El codigo a editar no existe: " + code);
        }
    }

    @Override
    public boolean delete(int code) throws WatchmanAppException {

        if(watchmanRepository.existsById(code)){
            try {
                watchmanRepository.deleteAllById(Collections.singleton(code));
                return true;
            }
            catch (Exception e){
                throw new WatchmanAppException("Este watchman no se puede eliminar, tiene relaciones: " + code);
            }
        }
        else {
            throw new WatchmanAppException("El codigo a borrar no existe: " + code);
        }

    }

    @Override
    public List<WatchmanDTO> list() {
        List<WatchmanEntity>  watchmanEntities = watchmanRepository.findAll();
        List<WatchmanDTO> watchmanDTOS = new ArrayList<>();
        for(WatchmanEntity watchman:watchmanEntities){
            watchmanDTOS.add(watchman.toWatchmanDTO());
        }
        return watchmanDTOS;
    }
}

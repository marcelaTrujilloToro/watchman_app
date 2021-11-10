package com.umanizales.watchman_app.infrastructure.adapters;

import com.umanizales.watchman_app.aplication.WatchmanAble;
import com.umanizales.watchman_app.domain.WatchmanDTO;
import com.umanizales.watchman_app.infrastructure.repositories.entity.WatchmanEntity;
import com.umanizales.watchman_app.infrastructure.repositories.repository.WatchmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Qualifier("PostgresWatchmanRepository")
@Repository("WatchmanPersistance")
public class PostgresWatchmanRepository implements WatchmanAble {

    //inyeccion de dependencias
    @Autowired
    private WatchmanRepository watchmanRepository;

    @Override
    public WatchmanDTO save(WatchmanDTO watchmanDTO) {

       return watchmanRepository.save(new WatchmanEntity(watchmanDTO)).toWatchmanDTO();
    }

    @Override
    public WatchmanDTO update(WatchmanDTO watchmanDTO) {
        return watchmanRepository.save(new WatchmanEntity(watchmanDTO)).toWatchmanDTO();
    }

    @Override
    public boolean delete(int code) {
        watchmanRepository.deleteAllById(Collections.singleton(code));
        return true;
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

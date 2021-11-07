package com.umanizales.watchman_app.aplication;

import com.umanizales.watchman_app.domain.WatchmanDTO;
import com.umanizales.watchman_app.infrastructure.repositories.repository.WatchmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;


public class WatchmanImpl implements WatchmanAble
{
    @Autowired
    @Qualifier("PostgresWatchmanRepository")
    private WatchmanRepository watchmanRepository;

    @Override
    public WatchmanDTO save(WatchmanDTO watchmanDTO) {
        return null;
    }

    @Override
    public WatchmanDTO update(WatchmanDTO watchmanDTO) {
        return null;
    }

    @Override
    public boolean delete(int code) {
        return false;
    }

    @Override
    public List<WatchmanDTO> list() {
        return null;
    }
}

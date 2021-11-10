package com.umanizales.watchman_app.aplication;

import com.umanizales.watchman_app.domain.WatchmanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchmanImpl implements WatchmanAble
{
    @Autowired
    @Qualifier("PostgresWatchmanRepository")
    private WatchmanAble watchmanPersistance;

    @Override
    public WatchmanDTO save(WatchmanDTO watchmanDTO) {

        return watchmanPersistance.save(watchmanDTO);
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
        return watchmanPersistance.list();
    }
}

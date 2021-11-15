package com.umanizales.watchman_app.aplication;

import com.umanizales.watchman_app.domain.WatchmanDTO;
import com.umanizales.watchman_app.exception.WatchmanAppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchmanImpl implements WatchmanAble
{
    @Autowired
    @Qualifier("PostgresWatchmanRepository")
    private WatchmanAble watchmanPersistence;

    @Override
    public WatchmanDTO save(WatchmanDTO watchmanDTO) {
        return watchmanPersistence.save(watchmanDTO);
    }

    @Override
    public WatchmanDTO update(int code, WatchmanDTO watchmanDTO) throws WatchmanAppException {
        return watchmanPersistence.update(code, watchmanDTO);
    }

    @Override
    public boolean delete(int code) throws WatchmanAppException {
        return watchmanPersistence.delete((code));
    }

    @Override
    public List<WatchmanDTO> list() {
        return watchmanPersistence.list();
    }
}

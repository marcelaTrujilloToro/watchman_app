package com.umanizales.watchman_app.infrastructure.repositories.repository;

import com.umanizales.watchman_app.infrastructure.repositories.entity.WatchmanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchmanRepository extends JpaRepository<WatchmanEntity, Integer>{

}

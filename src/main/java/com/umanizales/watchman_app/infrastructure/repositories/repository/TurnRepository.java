package com.umanizales.watchman_app.infrastructure.repositories.repository;

import com.umanizales.watchman_app.infrastructure.repositories.entity.TurnEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnRepository extends JpaRepository<TurnEntity, Integer> {

}

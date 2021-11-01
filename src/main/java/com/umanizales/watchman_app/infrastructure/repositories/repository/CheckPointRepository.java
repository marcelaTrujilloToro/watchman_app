package com.umanizales.watchman_app.infrastructure.repositories.repository;

import com.umanizales.watchman_app.infrastructure.repositories.entity.CheckPointEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckPointRepository extends JpaRepository<CheckPointEntity, Integer> {
}

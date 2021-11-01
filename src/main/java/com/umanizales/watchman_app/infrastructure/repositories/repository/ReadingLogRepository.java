package com.umanizales.watchman_app.infrastructure.repositories.repository;

import com.umanizales.watchman_app.infrastructure.repositories.entity.ReadingLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingLogRepository extends JpaRepository<ReadingLogEntity, Integer> {
}

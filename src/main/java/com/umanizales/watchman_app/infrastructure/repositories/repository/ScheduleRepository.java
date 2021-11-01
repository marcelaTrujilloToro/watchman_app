package com.umanizales.watchman_app.infrastructure.repositories.repository;

import com.umanizales.watchman_app.infrastructure.repositories.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Integer> {
}

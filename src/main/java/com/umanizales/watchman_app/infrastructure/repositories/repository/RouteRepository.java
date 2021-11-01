package com.umanizales.watchman_app.infrastructure.repositories.repository;

import com.umanizales.watchman_app.infrastructure.repositories.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<RouteEntity, Integer> {
}

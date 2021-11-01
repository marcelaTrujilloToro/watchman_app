package com.umanizales.watchman_app.infrastructure.repositories.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "schedule", schema = "public", catalog = "watchman-app")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ScheduleEntity {
    @Id
    @Column(name = "code", nullable = false)
    private int code;
    @ManyToOne
    @JoinColumn(name = "codeWatchman", referencedColumnName = "code", nullable = false)
    private WatchmanEntity whatchman;
    @ManyToOne
    @JoinColumn(name = "codeRoute", referencedColumnName = "code", nullable = false)
    private RouteEntity route;
}

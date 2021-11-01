package com.umanizales.watchman_app.infrastructure.repositories.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "route", schema = "public", catalog = "watchman-app")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RouteEntity {
    @Id
    @Column(name = "code", nullable = false)
    private int code;
    @Basic
    @Column(name = "hour", nullable = false)
    private Timestamp hour;
    @ManyToOne
    @JoinColumn(name = "codeCheckpoint", referencedColumnName = "code", nullable = false)
    private CheckPointEntity checkPoint;
    @ManyToOne
    @JoinColumn(name = "codeTurn", referencedColumnName = "code", nullable = false)
    private TurnEntity turn;
}

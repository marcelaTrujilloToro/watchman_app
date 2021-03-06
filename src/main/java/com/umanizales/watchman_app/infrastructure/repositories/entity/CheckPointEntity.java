package com.umanizales.watchman_app.infrastructure.repositories.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "checkPoint", schema = "public", catalog = "watchman-app")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CheckPointEntity {
    @Id
    @Column(name = "code", nullable = false)
    private int code;
    @Basic
    @Column(name = "description", nullable = false)
    private String description;
    @ManyToOne
    @JoinColumn(name = "codeLocation", referencedColumnName = "code", nullable = false)
    private LocationEntity location;
}

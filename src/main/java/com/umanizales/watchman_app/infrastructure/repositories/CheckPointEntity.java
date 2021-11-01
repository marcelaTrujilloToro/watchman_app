package com.umanizales.watchman_app.infrastructure.repositories;

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
    @Column(name = "description", nullable = false, length = -1)
    private String description;
    @ManyToOne
    @JoinColumn(name = "codeLocaation", referencedColumnName = "code", nullable = false)
    private LocationEntity location;
}

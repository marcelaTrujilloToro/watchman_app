package com.umanizales.watchman_app.infrastructure.repositories.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "notification", schema = "public", catalog = "watchman-app")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class NotificationEntity {
    @Id
    @Column(name = "code", nullable = false)
    private int code;
    @Basic
    @Column(name = "title", nullable = false)
    private String title;
    @Basic
    @Column(name = "description", nullable = false)
    private String description;
}

package com.umanizales.watchman_app.infrastructure.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name = "turn", schema = "public", catalog = "watchman-app")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TurnEntity {
    @Id
    @Column(name = "code", nullable = false)
    private int code;
    @Basic
    @Column(name = "date ", nullable = false)
    private LocalDate date;
    @Basic
    @Column(name = "hourStart", nullable = false)
    private Time hourStart;
    @Basic
    @Column(name = "hourEnd", nullable = false)
    private Time hourEnd;
    @ManyToOne
    @JoinColumn(name = "codeDiary", referencedColumnName = "code", nullable = false)
    private DiaryEntity diary;
    @ManyToOne
    @JoinColumn(name = "codeNotification", referencedColumnName = "code", nullable = false)
    private NotificationEntity notification;
    @ManyToOne
    @JoinColumn(name = "codeWatchman", referencedColumnName = "code", nullable = false)
    private WatchmanEntity watchman;
}
